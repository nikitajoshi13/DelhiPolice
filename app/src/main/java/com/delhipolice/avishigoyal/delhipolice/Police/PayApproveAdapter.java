package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.delhipolice.avishigoyal.delhipolice.Complains.ComplainLodge;
import com.delhipolice.avishigoyal.delhipolice.Database.UpdateStatus;
import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.List;


public class PayApproveAdapter extends RecyclerView.Adapter<PayApproveAdapter.MyHolder> {

    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    private List<OurData> listData;


    public PayApproveAdapter(Context obj, List listData)
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
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
        myHolder.complaint.setText(listData.get(i).getComplaints());
        myHolder.location.setText(listData.get(i).getLocation());
        myHolder.trafficlight.setText(listData.get(i).getTraffic());
        myHolder.comment.setText(listData.get(i).getComments());
        myHolder.linearLayout.setVisibility(View.VISIBLE);
        myHolder.vendor.setText(listData.get(i).getVendor());
        myHolder.accept.setText("Accept");
        myHolder.date.setText(listData.get(i).getDate());

        myHolder.accept.setVisibility(View.VISIBLE);
        myHolder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(obj,.class);
                Intent intent = new Intent();
                intent.setClass(obj, ComplainLodge.class);
                obj.startActivity(intent);
                Toast.makeText(obj, "Payment accepted", Toast.LENGTH_SHORT).show();

                //database
                //UpdateStatus updateStatus = new UpdateStatus(myHolder.complaint.getText().toString(),obj.getString(R.string.pending_payment),obj);
                //updateStatus.execute();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complaint,location,trafficlight,comment,vendor,date;
        Button accept;
        LinearLayout linearLayout;
        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            complaint=itemView.findViewById(R.id.complaintid);
            location=itemView.findViewById(R.id.locid);
            trafficlight=itemView.findViewById(R.id.traffid);
            comment=itemView.findViewById(R.id.commid);
            accept=itemView.findViewById(R.id.btnstat);
            vendor=itemView.findViewById(R.id.vendorid);
            linearLayout=itemView.findViewById(R.id.linearlay);
            linearLayout.invalidate();
            date=itemView.findViewById(R.id.date);



        }
    }
}