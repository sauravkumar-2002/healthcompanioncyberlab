package com.example.hj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapterpedo extends RecyclerView.Adapter<myadapterpedo.myviewholderpedo> {
    ArrayList<modelpedo> dataholderpedo;

    public myadapterpedo(ArrayList<modelpedo> dataholderpedo) {
        this.dataholderpedo = dataholderpedo;
    }

    @NonNull
    @Override
    public myadapterpedo.myviewholderpedo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowpedo, parent, false);
        return new myadapterpedo.myviewholderpedo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapterpedo.myviewholderpedo holder, int position) {
        holder.ddateandtime.setText(dataholderpedo.get(position).getDateandtime());
        holder.dtextviewstepcount.setText(dataholderpedo.get(position).getTextviewstepcount());
        holder.dtextview1stepdetect.setText(dataholderpedo.get(position).getTextview1stepdetect());
    }

    @Override
    public int getItemCount() {
        return dataholderpedo.size();
    }

    class myviewholderpedo extends RecyclerView.ViewHolder {
        public TextView ddateandtime;
        public TextView dtextviewstepcount;
        public TextView dtextview1stepdetect;

        public myviewholderpedo(@NonNull View itemView) {
            super(itemView);
            ddateandtime = (TextView) itemView.findViewById(R.id.dateandtimepedo);
            dtextviewstepcount = (TextView) itemView.findViewById(R.id.count);
            dtextview1stepdetect = (TextView) itemView.findViewById(R.id.detect);
        }
    }
}
