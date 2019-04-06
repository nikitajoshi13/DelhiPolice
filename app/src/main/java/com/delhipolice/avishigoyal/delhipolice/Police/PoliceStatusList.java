package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class PoliceStatusList extends AppCompatActivity {
    List<OurData> listMineList;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_status_list);
        listMineList = new ArrayList<>();
        OurData ourData =new OurData();
        OurData ourData1 =new OurData();
        ourData.setComplaints("Complaint 12345");
        ourData.setLocation("Kailash Colony");
        ourData.setTraffic("Id: 98765432");
        ourData.setComments("No Comments");
        ourData1.setComplaints("Complaint 678910");
        ourData1.setLocation("Amar Colony");
        ourData1.setTraffic("Id: 1234567");
        ourData1.setComments("yes Comments");
        Intent intent=getIntent();
        String value=intent.getStringExtra("Button");
        String stts=ourData.getStatus();
        switch(value){
            case "1":
                if(stts.equals("New")){
                    mAdapter = new NewAdapter(this, listMineList);
                    recyclerView.setAdapter(mAdapter);
                }
               // Toast.makeText(this, "New Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "2":
                if(stts.equals("Pending")){
                    ourData.setVendor("Abdul vendor");
                    ourData1.setVendor("Nadeem vendor");
                    listMineList.add(ourData);
                    listMineList.add(ourData1);
                    mAdapter = new PendingAdapter(this, listMineList);
                    recyclerView.setAdapter(mAdapter);
                }
               // Toast.makeText(this, "Pending Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "3":
                if(stts.equals("Payment Approved")){
                    ourData.setVendor("Abdul vendor");
                    ourData1.setVendor("Nadeem vendor");
                    listMineList.add(ourData);
                    listMineList.add(ourData1);
                    mAdapter = new PayApproveAdapter(this, listMineList);
                    recyclerView.setAdapter(mAdapter);
                }

               // Toast.makeText(this, "Complete Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "4":
                if(stts.equals("Payment Pending")){
                    ourData.setVendor("Abdul vendor");
                    ourData1.setVendor("Nadeem vendor");
                    listMineList.add(ourData);
                    listMineList.add(ourData1);
                    mAdapter = new PayPendingAdapter(this, listMineList);
                    recyclerView.setAdapter(mAdapter);
                }

               // Toast.makeText(this, "Approved Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "5":
                if(stts.equals("Payment Approved")){
                    ourData.setVendor("Abdul vendor");
                    ourData1.setVendor("Nadeem vendor");
                    listMineList.add(ourData);
                    listMineList.add(ourData1);
                    mAdapter = new CompleteAdapter(this, listMineList);
                    recyclerView.setAdapter(mAdapter);
                }
                // Toast.makeText(this, "Pending Payment Pressed", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
