package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchComplaint extends AsyncTask<String,String,String> {

        private String res = "";
        private boolean isSuccess=false;
        Boolean flag;
        private Context context;
        private MyPrefences myPrefences;
        private ConnectionClass connectionClass;
        public FetchComplaint(Context context){
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
                int userid = Integer.parseInt(myPrefences.getUserId());
                PreparedStatement stmt = con.prepareStatement("select * from complain where UserId = ?");
                stmt.setInt(1,userid);
                ResultSet rs = stmt.executeQuery();
                con.setAutoCommit(true);
                while(rs.next()) {
                    String id = rs.getString("id");
                    String location = rs.getString("Location");
                    String status = rs.getString("Status");
                    res = "Successfull";
                }
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
            Log.d("complaint","Successfully fetched list");
        }else{
            Toast.makeText(context,"Error in register "+result, Toast.LENGTH_LONG).show();
        }
    }
}
