package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.List;


public class PendingAdapter extends RecyclerView.Adapter<PendingAdapter.MyHolder> {

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    private List<OurData> listData;

    public PendingAdapter(Context obj, List listData)
    {
        this.obj=obj;
        this.listData=listData;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        //mlistener=listener;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(obj).inflate(R.layout.mylist,null);
        MyHolder myHolder=new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.complaint.setText(listData.get(i).getComplaints());
        myHolder.location.setText(listData.get(i).getLocation());
        myHolder.trafficlight.setText(listData.get(i).getTraffic());
        myHolder.comment.setText(listData.get(i).getComments());
        myHolder.linearLayout.setVisibility(View.VISIBLE);
        myHolder.callto.setVisibility(View.VISIBLE);
        myHolder.vendor.setText(listData.get(i).getVendor());
        myHolder.callto.setText("Call");
        myHolder.callto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complaint,location,trafficlight,comment,vendor;
        Button callto;
        LinearLayout linearLayout;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            complaint=itemView.findViewById(R.id.complaintid);
            location=itemView.findViewById(R.id.locid);
            trafficlight=itemView.findViewById(R.id.traffid);
            comment=itemView.findViewById(R.id.commid);
            callto=itemView.findViewById(R.id.btnstat);
            vendor=itemView.findViewById(R.id.vendorid);
            linearLayout=itemView.findViewById(R.id.linearlay);
           // linearLayout.invalidate();

        }
    }
}