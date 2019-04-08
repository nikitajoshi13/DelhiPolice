package com.delhipolice.avishigoyal.delhipolice.Police;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

import java.util.List;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.Myholders> {

    private VendorAdapter.OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    Context obj;
    int res;
    private List<VendorData> listData;


    public VendorAdapter(Context obj, List listData)
    {
        this.obj=obj;
        this.listData=listData;
    }
    public void setOnItemClickListener(VendorAdapter.OnItemClickListener listener){
        mlistener=listener;
    }

    public Myholders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(obj).inflate(R.layout.vendorlist,null);

        Myholders myHolder=new Myholders(view,mlistener);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Myholders myholder, int i) {
        myholder.name.setText(listData.get(i).getName());
        myholder.assign.setText(listData.get(i).getAssigned());
        myholder.handle.setText(listData.get(i).getHandled());
        myholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(obj,StatusButton.class);
                obj.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return listData.size();
    }

    public class Myholders extends RecyclerView.ViewHolder {
        TextView name,assign,handle;
        Button button;

        public Myholders(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            assign=itemView.findViewById(R.id.numassgin);
            handle=itemView.findViewById(R.id.tilldate);
            button=itemView.findViewById(R.id.assignbtn);


        }
    }
}