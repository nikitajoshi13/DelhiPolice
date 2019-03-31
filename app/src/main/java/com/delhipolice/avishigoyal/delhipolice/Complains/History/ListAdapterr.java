package com.delhipolice.avishigoyal.delhipolice.Complains.History;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delhipolice.avishigoyal.delhipolice.R;

public class ListAdapterr extends RecyclerView.Adapter  {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }
    private class ListViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mItemText;
                public ListViewHolder(View itemView)
                {
                    super(itemView);
                    mItemText=(TextView)itemView.findViewById(R.id.textview);

                }
                public void bindView(int position)
                {
                    mItemText.setText(OurData.title[position]);

                }
    }
}
