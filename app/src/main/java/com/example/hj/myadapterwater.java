package com.example.hj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapterwater extends RecyclerView.Adapter<myadapterwater.myviewholderwater> {
    ArrayList<modelwater> dataholderwater;

    public myadapterwater(ArrayList<modelwater> dataholderwater) {
        this.dataholderwater = dataholderwater;
    }


    @NonNull
    @Override
    public myadapterwater.myviewholderwater onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowwater,parent,false);
        return new myadapterwater.myviewholderwater(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myadapterwater.myviewholderwater holder, int position) {
        holder.ddateandtime.setText(dataholderwater.get(position).getDateandtimewater());
        holder.dglass.setText(dataholderwater.get(position).getGlass());
    }

    @Override
    public int getItemCount() { return dataholderwater.size() ;}

    class myviewholderwater extends RecyclerView.ViewHolder{
        public TextView ddateandtime;
        public TextView dglass;

        public myviewholderwater(@NonNull View itemView) {
            super(itemView);
            ddateandtime=(TextView)itemView.findViewById(R.id.displaydateandtime);
            dglass=(TextView)itemView.findViewById(R.id.displayglass);


        }

    }



}
