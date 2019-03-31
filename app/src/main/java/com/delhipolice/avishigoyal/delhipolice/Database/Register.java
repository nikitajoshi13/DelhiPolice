package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Register extends AsyncTask<String,String,String> {
    String res = "";
    boolean isSuccess=false;
    String name,email,phn,pass,user;
    Context context;
    ConnectionClass connectionClass;
    public Register(String name, String email, String phn, String user, String pass, Context context){
        this.name=name;
        this.email=email;
        this.phn=phn;
        this.pass=pass;
        this.user=user;
        this.context=context;
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
                PreparedStatement stt = con.prepareStatement("insert into test(name,email,phone,user,password) values(?,?,?,?,?)");
                stt.setString(1,name);
                stt.setString(2,email);
                stt.setString(3,phn);
                stt.setString(4,user);
                stt.setString(5,pass);
                stt.executeUpdate();
                res="Successfull";
                isSuccess=true;
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
            Toast.makeText(context,"Error in register"+result, Toast.LENGTH_LONG).show();
        }
    }
}
