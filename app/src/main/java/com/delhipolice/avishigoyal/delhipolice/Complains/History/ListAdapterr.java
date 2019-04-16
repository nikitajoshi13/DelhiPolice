package com.delhipolice.avishigoyal.delhipolice.Complains.History;

import android.content.Context;
import android.graphics.Color;
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
    String s1="Pending";
    String s2="Completed";
    String stat;

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
        myHolder.date.setText(data.get(i).getDate());

        stat=data.get(i).getStatus();
        myHolder.status.setText(stat);
        //boolean result = stat.equals(s1);
        if(stat.equals(s1))
        {
            myHolder.sta.setColorFilter(Color.RED);
        }
        if(stat.equals(s2))
        {
            myHolder.sta.setColorFilter(Color.GREEN );
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView complainid,location,status,date;
        ImageView sta;

        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            complainid=itemView.findViewById(R.id.complainID);
            location=itemView.findViewById(R.id.Location);
            status=itemView.findViewById(R.id.status);
            sta=itemView.findViewById(R.id.circle);
            date=itemView.findViewById(R.id.date);


        }
    }
}