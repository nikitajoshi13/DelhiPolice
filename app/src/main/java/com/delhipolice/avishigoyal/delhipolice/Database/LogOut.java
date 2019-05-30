package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;
import com.delhipolice.avishigoyal.delhipolice.Login.LoginActivity;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

public class LogOut extends AsyncTask<String,String,String> {
    String res="";
    Context context;
    MyPrefences myPrefences;
    public LogOut(Context context){
        this.context = context;
        myPrefences = new MyPrefences(context);
    }

    @Override
    protected void onPreExecute(){

        Toast.makeText(context,"Please wait...",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected String doInBackground(String... params){
        myPrefences.setTypeOfUser("1");
        myPrefences.setUserId("0");
        myPrefences.setComplainId("0");
        res = "Successful";
        return res;
    }
    @Override
    protected void onPostExecute(String result){
        if(result.equals("Successful")){
            Intent intent = new Intent(context, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"Error in fetchAllComplaintsACP "+result+"+", Toast.LENGTH_LONG).show();
        }
    }
}
