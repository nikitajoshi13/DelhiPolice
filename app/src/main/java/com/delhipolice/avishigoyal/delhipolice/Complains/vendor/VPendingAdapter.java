package com.delhipolice.avishigoyal.delhipolice.Complains.vendor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;
import java.util.List;

public class VPendingAdapter extends RecyclerView.Adapter <VPendingAdapter.MyHolder>{
    private OnItemClickListener mlistener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    Context obj;
    int res;
    private List<OurData> listData;
    String s;
    String s1="New";
    String s2="Pending";


    public VPendingAdapter(Context obj, List<OurData> listData) {
        this.obj = obj;
        this.listData = listData;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mlistener = listener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(obj).inflate(R.layout.mylist, null);

        MyHolder myHolder = new MyHolder(view, mlistener);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.complaint.setText(listData.get(i).getComplaints());
        myHolder.location.setText(listData.get(i).getLocation());
        myHolder.trafficlight.setText(listData.get(i).getTraffic());
        myHolder.comment.setText(listData.get(i).getComments());
//        myHolder.stat.setText(listData.get(i).getStat());
//        s=listData.get(i).getStat();
//        //boolean result = stat.equals(s1);
//        if(s.equals(s1))
//        {
//            myHolder.sta.setColorFilter(Color.MAGENTA);
//        }
//        if(s.equals(s2))
//        {
//            myHolder.sta.setColorFilter(Color.RED );
//        }
        //myHolder.assignedto.setText("Assign To");

        //myHolder.assignedto.setVisibility(View.VISIBLE);
        myHolder.assignedto.setText("Call");
        myHolder.assignedto.setVisibility(View.VISIBLE);

        myHolder.assignedto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(obj, VPendingAdapter.class);
//                obj.startActivity(intent);
                //code for automatic calling
                String no=listData.get(i).getPh();
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + no;
                i.setData(Uri.parse(p));
                obj.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        //listData=new ArrayList<OurData>();
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complaint, location, trafficlight, comment,stat;
        ImageView sta;
        Button assignedto;

        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            complaint = itemView.findViewById(R.id.complaintid);
            location = itemView.findViewById(R.id.locid);
            trafficlight = itemView.findViewById(R.id.traffid);
            comment = itemView.findViewById(R.id.commid);
//            stat=itemView.findViewById(R.id.status);
//            stat.setVisibility(View.VISIBLE);
//            sta=itemView.findViewById(R.id.circle);
//            sta.setVisibility(View.VISIBLE);
                       assignedto = itemView.findViewById(R.id.btnstat);

            //assignedto.invalidate();
            //vendor=itemView.findViewById(R.id.vendorid);


        }
    }
//    public VPendingAdapter(VendorStatus vendorStatus, List<OurData> l2) {
//    }
}
