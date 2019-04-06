package com.delhipolice.avishigoyal.delhipolice.Police;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.delhipolice.avishigoyal.delhipolice.Police.NewAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.OurData;
import com.delhipolice.avishigoyal.delhipolice.Police.VendorAdapter;
import com.delhipolice.avishigoyal.delhipolice.Police.VendorData;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class PoliceVendorstatus extends AppCompatActivity {
    List<VendorData> listMineList;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_vendorstatus);
        listMineList = new ArrayList<>();
        VendorData vendorData =new VendorData();
        VendorData vendorData1 =new VendorData();

        vendorData.setName("Jaban");
        vendorData.setAssigned("10");
        vendorData.setHandled("2");
        vendorData1.setName("Nasab");
        vendorData1.setAssigned("101");
        vendorData1.setHandled("21");
        listMineList.add(vendorData);
        listMineList.add(vendorData1);
        mAdapter = new VendorAdapter(this, listMineList);
        recyclerView.setAdapter(mAdapter);

    }
}
