package com.delhipolice.avishigoyal.delhipolice.Database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.History.ListAdapterr;
import com.delhipolice.avishigoyal.delhipolice.Complains.History.OurData;
import com.delhipolice.avishigoyal.delhipolice.common.MyPrefences;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FetchComplaint extends AsyncTask<String,String,String> {

        private String res = "";
        private Context context;
        private RecyclerView recyclerView;
        private MyPrefences myPrefences;
        private ConnectionClass connectionClass;
        private ArrayList<OurData> ourData = new ArrayList<>();
        OurData data;
        ListAdapterr listAdapter;
        Activity activity;
        boolean flag;

        public FetchComplaint(Context context,ArrayList<OurData> ourData,RecyclerView recyclerView){
            this.context=context;
            myPrefences = new MyPrefences(this.context);
            connectionClass = new ConnectionClass();
            activity = (Activity)context;
            //this.listAdapter=listAdapter;
            this.ourData=ourData;
            this.recyclerView=recyclerView;
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
                if(rs!=null) {
                    while (rs.next()) {
                        data = new OurData();
                        String id = rs.getString("id");
                        String location = rs.getString("Location");
                        String status = rs.getString("Status");
                        data.setComplainID(id);
                        data.setLocation(location);
                        data.setStatus(status);
                        ourData.add(data);
                        flag = true;
                    }
                }else{
                    res = "Not registered complain yet";
                }
            }
            if(flag){
                res="Successful";
            }
        }
        catch (Exception e){
            res=e.toString();
        }
        return res;
    }


        @Override
        protected void onPostExecute(String result){

        if(result.equals("Successful")){
            Log.d("complaint","Successfully fetched list");
            listAdapter = new ListAdapterr(context,ourData);
            recyclerView.setAdapter(listAdapter);
        }else{
            Toast.makeText(context,"Error in fetch complaint "+result, Toast.LENGTH_LONG).show();
        }
    }
}
