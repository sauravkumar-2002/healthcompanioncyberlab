package com.example.hj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

  import java.util.ArrayList;

public class myadapterex extends RecyclerView.Adapter<myadapterex.myviewholder> {
ArrayList<model> dataholder;

    public myadapterex(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

holder.dstarttime.setText(dataholder.get(position).getStarttime());
holder.dendtime.setText(dataholder.get(position).getEndtime());
        holder.ddate.setText(dataholder.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dataholder.size() ;
    }

    class myviewholder extends RecyclerView.ViewHolder {
       public TextView ddate;
       public TextView dstarttime;
       public TextView dendtime;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dstarttime=(TextView)itemView.findViewById(R.id.displaystarttime);
            ddate=(TextView)itemView.findViewById(R.id.displaydate);
            dendtime=(TextView)itemView.findViewById(R.id.displayendtime);
        }
    }
}
