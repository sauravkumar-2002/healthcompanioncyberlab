package com.example.hj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadaptersleep  extends RecyclerView.Adapter<myadaptersleep.myviewholdersleep> {
    ArrayList<modelsleep> dataholdersleep;

    public myadaptersleep(ArrayList<modelsleep> dataholdersleep) {
        this.dataholdersleep = dataholdersleep;
    }

    @NonNull
    @Override
    public myadaptersleep.myviewholdersleep onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowsleep,parent,false);
        return new myadaptersleep.myviewholdersleep(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadaptersleep.myviewholdersleep holder, int position) {
        holder.ddatesleep.setText(dataholdersleep.get(position).getDatesleep());
        holder.dstatussleep.setText(dataholdersleep.get(position).getStatussleep());
    }

    @Override
    public int getItemCount() {
        return dataholdersleep.size() ;
    }
    class myviewholdersleep extends RecyclerView.ViewHolder {
        public TextView ddatesleep;
        public TextView dstatussleep;

        public myviewholdersleep(@NonNull View itemView) {
            super(itemView);
            ddatesleep=(TextView)itemView.findViewById(R.id.displaydatesleep);
            dstatussleep=(TextView)itemView.findViewById(R.id.displaystatus);


        }
    }
}
