package com.delhipolice.avishigoyal.delhipolice.Complains.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

//import com.delhipolice.avishigoyal.delhipolice.Police.CompleteAdapter;
//import com.delhipolice.avishigoyal.delhipolice.Police.NewAdapter;
//import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
//import com.delhipolice.avishigoyal.delhipolice.Police.PayApproveAdapter;
//import com.delhipolice.avishigoyal.delhipolice.Police.PayPendingAdapter;
//import com.delhipolice.avishigoyal.delhipolice.Police.PendingAdapter;
import com.delhipolice.avishigoyal.delhipolice.Database.FetchAllComplaintVendor;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class VendorStatus extends AppCompatActivity {
    List<OurData> listVendor,l1,l2,l3;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_status);


        recyclerView = findViewById(R.id.vendorrecycle);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        String value = intent.getStringExtra("Button");

        ArrayList<OurData> data =new ArrayList<>();

        //database
        FetchAllComplaintVendor fetch = new FetchAllComplaintVendor(value,getApplicationContext(),data,recyclerView);
        fetch.execute();

        /*listVendor= new ArrayList<>();
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        l3=new ArrayList<>();
       // l4=new ArrayList<>();
        //l5=new ArrayList<>();


        OurData ourData1 = new OurData();
        OurData ourData2 = new OurData();
        OurData ourData3 = new OurData();
        OurData ourData4 = new OurData();
       // com.delhipolice.avishigoyal.delhipolice.Police.OurData ourData4 = new com.delhipolice.avishigoyal.delhipolice.Police.OurData();
        //com.delhipolice.avishigoyal.delhipolice.Police.OurData ourData5 = new OurData();

        ourData1.setComplaints("Complaint 12345");
        ourData1.setLocation("Kailash Colony");
        ourData1.setTraffic("Id: 98765432");
        ourData1.setComments("No Comments");
        ourData1.setStatus("Complains");
        ourData1.setStat("New");
        ourData1.setPh("01122114165");

        ourData4.setComplaints("Complaint 12445");
        ourData4.setLocation("Dilshad Colony");
        ourData4.setTraffic("Id: 98445432");
        ourData4.setComments("No Comments");
        ourData4.setStatus("Complains");
        ourData4.setStat("Pending");
        ourData4.setPh("01122114165");

        // ourData1.setVendor("Abdul vendor");


        ourData2.setComplaints("Complaint 20101");
        ourData2.setLocation("Kashmere Gate");
        ourData2.setTraffic("Id: 98765432");
        ourData2.setComments("No Comments");
        ourData2.setStatus("Payment");
        ourData2.setPh("01122114165");

        //ourData2.setVendor("Nadeem vendor");


        ourData3.setComplaints("Complaint 12345");
        ourData3.setLocation("Kailash Colony");
        ourData3.setTraffic("Id: 98765432");
        ourData3.setComments("No Comments");
        ourData3.setStatus("Completed");
        ourData3.setPh("01122114165");

        //ourData3.setVendor("Madina vendor");


//        ourData4.setComplaints("Complaint 12345");
//        ourData4.setLocation("Kailash Colony");
//        ourData4.setTraffic("Id: 98765432");
//        ourData4.setComments("No Comments");
//        ourData4.setStatus("Payment Pending");
//        ourData4.setVendor("Nadil vendor");
//
//
//        ourData5.setComplaints("Complaint 678910");
//        ourData5.setLocation("Amar Colony");
//        ourData5.setTraffic("Id: 1234567");
//        ourData5.setComments("yes Comments");
//        ourData5.setStatus("Complete");
//        ourData5.setVendor("Deemak vendor");

        listVendor.add(ourData1);
        listVendor.add(ourData2);
        listVendor.add(ourData3);
        listVendor.add(ourData4);
//        listMineList.add(ourData5);


        for (int i=0;i<listVendor.size();i++)
        {
            if(listVendor.get(i).getStatus().equals("Complains")){
                l1.add(listVendor.get(i));
            }
            else if(listVendor.get(i).getStatus().equals("Payment")) {
                l2.add(listVendor.get(i));
            }
            else if(listVendor.get(i).getStatus().equals("Completed")){
                l3.add(listVendor.get(i));
            }
//            else if(listMineList.get(i).getStatus().equals("Payment Approved")){
//                l4.add(listMineList.get(i));
//            }
//            else if(listMineList.get(i).getStatus().equals("Payment Pending")){
//                l5.add(listMineList.get(i));
//            }
            else {

            }
        }

        Intent intent = getIntent();
        String value = intent.getStringExtra("Button");

        switch (value) {
            case "1":
                mAdapter = new VComplainsAdapter(this, l1);
                recyclerView.setAdapter(mAdapter);
                // Toast.makeText(this, "New Button Pressed", Toast.LENGTH_SHORT).show();

                break;
            case "2":
                mAdapter = new VPendingAdapter(this, l2);
                recyclerView.setAdapter(mAdapter);
                break;
            case "3":
                mAdapter = new VCompletedAdapter(this, l3);
                recyclerView.setAdapter(mAdapter);

                break;
//            case "4":
//                Log.d("abc","abc");
//                mAdapter = new PayApproveAdapter(this, l4);
//                recyclerView.setAdapter(mAdapter);
//                // Toast.makeText(this, "Approved Button Pressed", Toast.LENGTH_SHORT).show();
//                break;
//            case "5":
//                mAdapter = new PayPendingAdapter(this, l5);
//                recyclerView.setAdapter(mAdapter);
//                break;
        }*/
    }


}


