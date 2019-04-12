package com.delhipolice.avishigoyal.delhipolice.Complains.History;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;


public class TabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    int position;
    private TextView textView;
    OurData ab,bc;

    public static TabFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);

        ab = new OurData();
        ab.setComplainID("201904231122");
        ab.setLocation("Kashmere Gate");
        ab.setDate("Friday, 12 April, 2019");
        ab.setStatus("Pending");
        bc = new OurData();
        bc.setComplainID("201904231123");
        bc.setDate("Monday, 8 April, 2019");

        bc.setLocation("Dilshad Garden");
        bc.setStatus("Completed");

        ArrayList<OurData> data =new ArrayList<>();
        data.add(ab);
        data.add(bc);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        ListAdapterr listAdapter = new ListAdapterr(getContext(),data);
        recyclerView.setAdapter((RecyclerView.Adapter) listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
  //  @Override
 //   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
   //     super.onViewCreated(view, savedInstanceState);
     //   textView = (TextView) view.findViewById(R.id.textView);

       // textView.setText("No complain lodged by you!");



