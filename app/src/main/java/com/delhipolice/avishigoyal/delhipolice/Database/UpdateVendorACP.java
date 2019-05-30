package com.delhipolice.avishigoyal.delhipolice.Database;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateVendorACP extends AsyncTask<String,String,String> {

    private String res;
    private Context context;
    private ConnectionClass connectionClass;
    String name;

    public UpdateVendorACP(String name, Context context) {
        this.name = name;
        this.context = context;
        connectionClass = new ConnectionClass();
    }

    @Override
    protected void onPreExecute() {

        Toast.makeText(context, "Please wait...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Connection con = connectionClass.Conn();
            if (con == null) {
                res = "check connection" + con;
            } else {
                PreparedStatement stmt = con.prepareStatement("select sno from test where name=?");
                stmt.setString(1, name);
                ResultSet rs = stmt.executeQuery();
                con.setAutoCommit(true);
                while (rs.next()) {
                    String id = rs.getString("sno");
                    PreparedStatement stt = con.prepareStatement("update vendor set assigned = assigned-1, total = total + 1 where UserID=?");
                    stt.setInt(1, Integer.parseInt(id));
                    stt.executeUpdate();
                    res = "Successfull";
                }

            }
        } catch (Exception e) {
            res = e.toString();
        }
        return res;
    }


    @Override
    protected void onPostExecute(String result) {

        if (result.equals("Successfull")) {

            Toast.makeText(context, "Paid to a vendor", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ComplainLodge.class);
            context.startActivity(intent);

        } else {
            Toast.makeText(context, "Error in update vendor acp " + result, Toast.LENGTH_LONG).show();
        }
    }
}