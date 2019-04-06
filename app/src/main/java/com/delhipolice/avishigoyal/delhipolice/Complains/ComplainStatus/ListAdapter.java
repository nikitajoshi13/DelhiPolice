package com.delhipolice.avishigoyal.delhipolice.Complains.ComplainStatus;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.Complains.History.OurData;
import com.delhipolice.avishigoyal.delhipolice.R;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    String[] listData;


    public ListAdapter(Context obj,String [] listData)
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
        myHolder.textView.setText(listData[i]);
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyHolder(@NonNull View itemView, final OnItemClickListener listener) {

            super(itemView);
            //textView=itemView.findViewById(R.id.tv1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}