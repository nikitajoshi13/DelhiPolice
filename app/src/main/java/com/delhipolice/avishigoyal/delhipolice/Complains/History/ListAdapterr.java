package com.delhipolice.avishigoyal.delhipolice.Complains.History;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.ArrayList;

public class ListAdapterr extends RecyclerView.Adapter<ListAdapterr.MyHolder> {

    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    ArrayList<OurData> data;


    public ListAdapterr(Context obj,ArrayList<OurData> data)
    {
        this.obj=obj;
        this.data=data;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mlistener=listener;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(obj).inflate(R.layout.list_item,null);

        MyHolder myHolder=new MyHolder(view, (OnItemClickListener) mlistener);


        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.complainid.setText(data.get(i).getComplainID());
        myHolder.location.setText(data.get(i).getLocation());
        myHolder.status.setText(data.get(i).getStatus());
//        if(data.get(i).getStatus().equals("Pending"))
//        {
//            myHolder.sta.setColorFilter(R.color.red);
//        }
//        if(data.get(i).getStatus().equals("Completed"))
//        {
//            myHolder.sta.setColorFilter(R.color.green);
//        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complainid,location,status;
        ImageView sta;

        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            complainid=itemView.findViewById(R.id.complainID);
            location=itemView.findViewById(R.id.Location);
            status=itemView.findViewById(R.id.status);
            sta=itemView.findViewById(R.id.circle);


        }
    }
}