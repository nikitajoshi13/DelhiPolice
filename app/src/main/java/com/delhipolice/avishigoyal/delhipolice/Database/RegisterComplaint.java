package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterComplaint extends AsyncTask<String,String,String> {
    String res = "";
    String ID,Location,Status,UserId;
    Context context;
    String Date;
    ConnectionClass connectionClass;

    public RegisterComplaint(String ID, String Location, String Status,String Date, String UserId, Context context){
        this.ID = ID;
        this.Location = Location;
        this.Status = Status;
        this.Date = Date;
        this.UserId = UserId;
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
                PreparedStatement stt = con.prepareStatement("insert into complain(ID,Location,Status,Date,UserId) values(?,?,?,?,?)");
                stt.setString(1,ID);
                stt.setString(2,Location);
                stt.setString(3,Status);
                stt.setString(4,Date);
                stt.setString(5,UserId);
                stt.executeUpdate();
                res="Successfull";
            }
        }
        catch (Exception e){
            res=e.toString();
        }
        return res;
    }
    @Override
    protected void onPostExecute(String result){

        if(result.equals("Successfull")){
            Toast.makeText(context,"Complain Registered"+result, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context,"Error in register"+result, Toast.LENGTH_LONG).show();
        }
    }
}
