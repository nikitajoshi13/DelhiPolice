package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Police.CompleteAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.NewAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
import com.delhipolice.avishigoyal.delhipolice.Police.PayApproveAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.PayPendingAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.PendingAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.VendorAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.VendorData;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FetchVendor extends AsyncTask<String,String,String> {

    private String userID = "3";
    private String res = "";
    private Context context;
    private RecyclerView recyclerView;
    private ConnectionClass connectionClass;
    private ArrayList<VendorData> vendorData = new ArrayList<>();
    VendorData data;
    private RecyclerView.Adapter adapter;


    public FetchVendor(Context context,ArrayList<VendorData> vendorData,RecyclerView recyclerView){

        this.context=context;
        connectionClass = new ConnectionClass();
        this.vendorData=vendorData;
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
                PreparedStatement stmt = con.prepareStatement("select a.name, b.assigned, b.total from test as a inner join vendor as b on a.sno=b.UserId where a.user = ?");
                stmt.setString(1,userID);
                ResultSet rs = stmt.executeQuery();
                con.setAutoCommit(true);
                while(rs.next()) {
                    data = new VendorData();
                    String id = rs.getString("name");
                    String location = rs.getString("assigned");
                    String status = rs.getString("total");
                    data.setName(id);
                    data.setAssigned(location);
                    data.setHandled(status);
                    vendorData.add(data);
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
                adapter = new VendorAdapter(context, vendorData);
                recyclerView.setAdapter(adapter);
        }else{
            Toast.makeText(context,"Error in fetch vendor "+result, Toast.LENGTH_LONG).show();
        }
    }
}
