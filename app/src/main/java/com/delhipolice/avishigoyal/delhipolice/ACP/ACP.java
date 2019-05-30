package com.delhipolice.avishigoyal.delhipolice.ACP;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delhipolice.avishigoyal.delhipolice.ACP.OurData;
import com.delhipolice.avishigoyal.delhipolice.Database.FetchAllComplaintACP;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class ACP extends AppCompatActivity {

    List<OurData> listMineList,l1,l2,l3;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acp);

        recyclerView = findViewById(R.id.acp);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //database
        /*Intent intent = getIntent();
        String value = intent.getStringExtra("Button");

        ArrayList<OurData> data =new ArrayList<>();

        FetchAllComplaintACP fetch = new FetchAllComplaintACP(value,getApplicationContext(),data,recyclerView);
        fetch.execute();*/

        listMineList = new ArrayList<>();
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        l3=new ArrayList<>();

        OurData ourData1 = new OurData();
        OurData ourData2 = new OurData();
        OurData ourData3 = new OurData();

        ourData1.setComplaints("Complaint 12345");
        ourData1.setLocation("Kailash Colony");
        ourData1.setTraffic("Id: 98765432");
        ourData1.setComments("No Comments");
        ourData1.setStatus("Pay approve");
        ourData1.setVendor("Abdul vendor");
        ourData1.setBeatofficer("Officer Mukesh");


        ourData2.setComplaints("Complaint 20101");
        ourData2.setLocation("Kashmere Gate");
        ourData2.setTraffic("Id: 98765432");
        ourData2.setComments("No Comments");
        ourData2.setStatus("Pending");
        ourData2.setVendor("Nadeem vendor");
        ourData2.setBeatofficer("Officer Ravindar");


        ourData3.setComplaints("Complaint 12345");
        ourData3.setLocation("Kailash Colony");
        ourData3.setTraffic("Id: 98765432");
        ourData3.setComments("No Comments");
        ourData3.setStatus("Complete");
        ourData3.setVendor("Madina vendor");
        ourData3.setBeatofficer("Officer Bla");

        for (int i=0;i<listMineList.size();i++)
        {
            if(listMineList.get(i).getStatus().equals("Pay Approve")){
                l1.add(listMineList.get(i));
            }
            else if(listMineList.get(i).getStatus().equals("Pending")) {
                l2.add(listMineList.get(i));
            }
            else if(listMineList.get(i).getStatus().equals("Complete")) {
                l3.add(listMineList.get(i));
            }
            else {

            }

        }

        Intent intent = getIntent();
        String value = intent.getStringExtra("Button1");

        switch (value) {
            case "1":
                mAdapter = new PendingAdapter(this, l1);
                recyclerView.setAdapter(mAdapter);
                // Toast.makeText(this, "New Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "2":
                mAdapter = new PayApproveAdapter(this, l2);
                recyclerView.setAdapter(mAdapter);
                break;
            case "3":
                mAdapter = new CompleteAdapter(this, l3);
                recyclerView.setAdapter(mAdapter);

                break;

        }
    }
}
