package com.example.hj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Listitem> listitems;
    private Context context;

    public MyAdapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Listitem listitem = listitems.get(position);

        holder.textViewHead.setText(listitem.getHead());
        holder.textViewDesc.setText(listitem.getDesc());
        holder.textViewDateandtime.setText(listitem.getDatetime());


    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewDesc;
        public TextView textViewDateandtime;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView)itemView.findViewById(R.id.head);
            textViewDesc = (TextView)itemView.findViewById(R.id.descr);
            textViewDateandtime = (TextView)itemView.findViewById(R.id.dateandtime1);

        }
    }

}




