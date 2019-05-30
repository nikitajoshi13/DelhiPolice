package com.delhipolice.avishigoyal.delhipolice.Database;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import com.delhipolice.avishigoyal.delhipolice.Police.CompleteAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.NewAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
import com.delhipolice.avishigoyal.delhipolice.Police.PayApproveAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.PayPendingAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.PendingAdapter;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FetchAllComplaint extends AsyncTask<String,String,String> {

    private String res = "";
    private Context context;
    private RecyclerView recyclerView;
    private ConnectionClass connectionClass;
    private ArrayList<OurData> ourData = new ArrayList<>();
    OurData data;
    private RecyclerView.Adapter adapter;
   // Activity activity;
    String status;

    public FetchAllComplaint(String status,Context context,ArrayList<OurData> ourData,RecyclerView recyclerView){
        this.status=status;
        this.context=context;
        connectionClass = new ConnectionClass();
        //activity = (Activity)context;
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
                PreparedStatement stmt = con.prepareStatement("select * from complain where Status = ?");
                stmt.setString(1,status);
                ResultSet rs = stmt.executeQuery();
                con.setAutoCommit(true);
                if(rs!=null) {
                    while (rs.next()) {
                        data = new OurData();
                        String id = rs.getString("id");
                        String location = rs.getString("Location");
                        String status = rs.getString("Status");
                        data.setComplaints(id);
                        data.setLocation(location);
                        data.setStatus(status);
                        stmt = con.prepareStatement("select * from test where sno=?");
                        stmt.setString(1,rs.getString("Vendor"));
                        rs = stmt.executeQuery();
                        while(rs.next()) {
                            data.setVendor(rs.getString("name"));
                        }
                        ourData.add(data);
                        res = "Successfull";

                    }
                }else{
                res = "Not registered complain yet";
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
            if(status.equals(context.getString(R.string.new_status))) {
                adapter = new NewAdapter(context, ourData);
                recyclerView.setAdapter(adapter);
            }
            else if(status.equals(context.getString(R.string.pending))){
                    adapter = new PendingAdapter(context,ourData);
                    recyclerView.setAdapter(adapter);
            }
            else if(status.equals(context.getString(R.string.completed))) {
                adapter = new CompleteAdapter(context, ourData);
                recyclerView.setAdapter(adapter);
            }
            else if(status.equals(context.getString(R.string.approve_payment))) {
                adapter = new PayApproveAdapter(context, ourData);
                recyclerView.setAdapter(adapter);
            }
            else if(status.equals(context.getString(R.string.pending_payment))) {
                adapter = new PayPendingAdapter(context, ourData);
                recyclerView.setAdapter(adapter);
            }

        }else{
            Toast.makeText(context,"Error in fetchAllComplaints "+result, Toast.LENGTH_LONG).show();
        }
    }

}
