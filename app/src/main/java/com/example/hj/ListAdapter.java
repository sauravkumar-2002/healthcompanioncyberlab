package com.example.hj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private TextView mDateStepCountText;
    ArrayList<DateStepsModel> mStepCountList;
    LayoutInflater mLayoutInflater;
    Context mcontext;
    public ListAdapter(ArrayList<DateStepsModel>mStepCountList,Context mcontext){
        this.mStepCountList=mStepCountList;
        this.mcontext=mcontext;
        this.mLayoutInflater=(LayoutInflater)this.mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mStepCountList.size();
    }

    @Override
    public Object getItem(int position) {
        return mStepCountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){

            convertView = mLayoutInflater.inflate(R.layout.list_rows, parent, false);
        }

        mDateStepCountText = (TextView)convertView.findViewById(R.id.sensor_name);
        mDateStepCountText.setText(mStepCountList.get(position).mDate + " - Total Steps: " + String.valueOf(mStepCountList.get(position).mStepCount));

        return convertView;
    }

}
