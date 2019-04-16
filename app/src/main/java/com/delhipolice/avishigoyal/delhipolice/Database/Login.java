package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AsyncTask<String,String,String> {
    String res = "";
    boolean isSuccess=false;
    String email,pass,user;
    Boolean flag;
    Context context;
    MyPrefences myPrefences;
    ConnectionClass connectionClass;
    public Login(String email, String pass, Context context){
        this.email=email;
        this.pass=pass;
        this.context=context;
        myPrefences = new MyPrefences(this.context);
        connectionClass = new ConnectionClass();
    }
    @Override
    protected void onPreExecute(){
        Toast.makeText(context,"Please wait...",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected String doInBackground(String... params){
        try{
            Connection con = connectionClass.Conn();
            if(con == null){
                res="check connection"+con;
            }
            else {
                String sql = "select * from test";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                con.setAutoCommit(true);
                while(rs.next()) {
                    String email_db = rs.getString("email");
                    String pass_db = rs.getString("password");
                    String user_db = rs.getString("user");
                    int user_id = Integer.parseInt(rs.getString("sno"));
                    if (email.equals(email_db)&&pass.equals(pass_db)) {
                        flag=true;
                        user=user_db;
                        myPrefences.setUserId(user_id);
                    }
                }
                if(flag) {
                    res = "Successfull";
                    isSuccess = true;
                }else{
                    res = "Unsuccessfull";
                    isSuccess = false;
                }
            }
        }
        catch (Exception e){
            isSuccess=false;
            res=e.toString();
        }
        return res;
    }
    @Override
    protected void onPostExecute(String result){

        if(result.equals("Successfull")){
            Intent intent = new Intent(context, ComplainLodge.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"Error in register "+result+" "+user, Toast.LENGTH_LONG).show();
        }
    }
}

