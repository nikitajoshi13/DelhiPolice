package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.List;


public class PayPendingAdapter extends RecyclerView.Adapter<PayPendingAdapter.MyHolder> {

    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    private List<OurData> listData;


    public PayPendingAdapter(Context obj, List listData)
    {
        this.obj=obj;
        this.listData=listData;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener=listener;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(obj).inflate(R.layout.mylist,null);

        MyHolder myHolder=new MyHolder(view,mlistener);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.complaint.setText(listData.get(i).getComplaints());
        myHolder.location.setText(listData.get(i).getLocation());
        myHolder.trafficlight.setText(listData.get(i).getTraffic());
        myHolder.comment.setText(listData.get(i).getComments());
        myHolder.vendor.setVisibility(View.VISIBLE);
        myHolder.vendor.setText(listData.get(i).getVendor());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complaint,location,trafficlight,comment,vendor;
        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            complaint=itemView.findViewById(R.id.complaintid);
            location=itemView.findViewById(R.id.locid);
            trafficlight=itemView.findViewById(R.id.traffid);
            comment=itemView.findViewById(R.id.commid);
            vendor=itemView.findViewById(R.id.vendorid);


        }
    }
}