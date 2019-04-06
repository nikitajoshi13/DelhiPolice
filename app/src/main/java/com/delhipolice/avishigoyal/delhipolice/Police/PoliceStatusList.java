package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.History.ListAdapterr;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class PoliceStatusList extends AppCompatActivity {
    List<OurData> listMineList,l1,l2,l3,l4,l5;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_status_list);


        recyclerView = findViewById(R.id.policerecycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        listMineList = new ArrayList<>();
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        l3=new ArrayList<>();
        l4=new ArrayList<>();
        l5=new ArrayList<>();


        OurData ourData1 = new OurData();
        OurData ourData2 = new OurData();
        OurData ourData3 = new OurData();
        OurData ourData4 = new OurData();
        OurData ourData5 = new OurData();
        ourData1.setComplaints("Complaint 12345");
        ourData1.setLocation("Kailash Colony");
        ourData1.setTraffic("Id: 98765432");
        ourData1.setComments("No Comments");
        ourData1.setStatus("New");
        ourData1.setVendor("Abdul vendor");
        ourData2.setVendor("Nadeem vendor");
        ourData3.setVendor("Madina vendor");
        ourData4.setVendor("Nadil vendor");
        ourData5.setVendor("Deemak vendor");
        ourData2.setComplaints("Complaint 20101");
        ourData2.setLocation("Kashmere Gate");
        ourData2.setTraffic("Id: 98765432");
        ourData2.setComments("No Comments");
        ourData2.setStatus("Pending");
        ourData3.setComplaints("Complaint 12345");
        ourData3.setLocation("Kailash Colony");
        ourData3.setTraffic("Id: 98765432");
        ourData3.setComments("No Comments");
        ourData3.setStatus("Payement Approved");
        ourData4.setComplaints("Complaint 12345");
        ourData4.setLocation("Kailash Colony");
        ourData4.setTraffic("Id: 98765432");
        ourData4.setComments("No Comments");
        ourData4.setStatus("Payment Pending");
        ourData5.setComplaints("Complaint 678910");
        ourData5.setLocation("Amar Colony");
        ourData5.setTraffic("Id: 1234567");
        ourData5.setComments("yes Comments");
        ourData5.setStatus("Complete");
        listMineList.add(ourData1);
        listMineList.add(ourData2);
        listMineList.add(ourData3);
        listMineList.add(ourData4);
        listMineList.add(ourData5);


        for (int i=0;i<listMineList.size();i++)
        {
            if(listMineList.get(i).getStatus().equals("New")){
                l1.add(listMineList.get(i));
            }
            else if(listMineList.get(i).getStatus().equals("Pending")) {
                l2.add(listMineList.get(i));
            }
            else if(listMineList.get(i).getStatus().equals("Payment Approved")){
                l3.add(listMineList.get(i));
            }
            else if(listMineList.get(i).getStatus().equals("Payment Pending")){
                l4.add(listMineList.get(i));
            }
            else{
                l5.add(listMineList.get(i));
            }
        }

        Intent intent = getIntent();
        String value = intent.getStringExtra("Button");

        switch (value) {
            case "1":
                    mAdapter = new NewAdapter(this, l1);
                    recyclerView.setAdapter(mAdapter);
                // Toast.makeText(this, "New Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "2":
                    mAdapter = new PendingAdapter(this, l2);
                    recyclerView.setAdapter(mAdapter);
                break;
            case "5":
                mAdapter = new CompleteAdapter(this, l3);
                recyclerView.setAdapter(mAdapter);

                break;
            case "4":
                mAdapter = new PayApproveAdapter(this, l4);
                recyclerView.setAdapter(mAdapter);
                // Toast.makeText(this, "Approved Button Pressed", Toast.LENGTH_SHORT).show();
                break;
            case "3":
                mAdapter = new PayPendingAdapter(this, l5);
                recyclerView.setAdapter(mAdapter);
                break;
        }
    }


}
