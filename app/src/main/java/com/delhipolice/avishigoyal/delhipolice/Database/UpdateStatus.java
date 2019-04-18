package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateStatus extends AsyncTask<String,String,String> {

    private String res;
    private Context context;
    private ConnectionClass connectionClass;
    String complainID,status;

    public UpdateStatus(String complainID,String status,Context context){
        this.complainID = complainID;
        this.status = status;
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
                PreparedStatement stmt = con.prepareStatement("update complain set status = ? where ID = ?");
                stmt.setString(1,status);
                stmt.setString(2,complainID);
                stmt.executeUpdate();
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

            Toast.makeText(context,"Status Updated" ,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Error in register "+result, Toast.LENGTH_LONG).show();
        }
    }

}
