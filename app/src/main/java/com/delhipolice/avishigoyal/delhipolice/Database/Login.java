package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AsyncTask<String,String,String> {
    String res = "";
    boolean isSuccess=false;
    String name,phone,user;
    Boolean flag;
    Context context;
    MyPrefences myPrefences;
    ConnectionClass connectionClass;
    public Login(String name, String phone, Context context){
        this.name = name;
        this.phone = phone;
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
                    String phone_db = rs.getString("phone");
                    String user_db = rs.getString("user");
                    int user_id = Integer.parseInt(rs.getString("sno"));
                    if (phone_db.equals(phone)) {
                        flag=true;
                        user=user_db;
                        myPrefences.setTypeOfUser(String.valueOf(user_db));
                        myPrefences.setUserId(String.valueOf(user_id));
                        break;
                    }else{

                        flag=false;
                    }
                }
                if(flag) {
                    res = "Successful";
                    isSuccess = true;
                }else{

                    String user_type_id = myPrefences.getTypeOfUser();
                    PreparedStatement stt = con.prepareStatement("insert into test(name,phone,user) values(?,?,?)");
                    stt.setString(1,name);
                    stt.setString(2,phone);
                    stt.setString(3,user_type_id);
                    stt.executeUpdate();
                    stt = con.prepareStatement("select * from test where phone = ?");
                    stt.setString(1,phone);
                    rs = stt.executeQuery();
                    con.setAutoCommit(true);
                    while(rs.next()) {
                        int user_id = Integer.parseInt(rs.getString("sno"));
                        String user_type = rs.getString("user");
                        myPrefences.setTypeOfUser(String.valueOf(user_type));
                        myPrefences.setUserId(String.valueOf(user_id));
                        flag = true;
                    }
                    if(flag){
                        res = "Successful";
                        isSuccess = true;
                    }else {
                        res = "UnSuccessful";
                        isSuccess = true;
                    }
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

        if(result.equals("Successful")){
            Intent intent = new Intent(context, ComplainLodge.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"Error in fetchAllComplaintsACP "+result+" "+user, Toast.LENGTH_LONG).show();
        }
    }
}

