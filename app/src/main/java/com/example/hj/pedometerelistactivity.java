package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class pedometerelistactivity extends AppCompatActivity {

    private ListView mSensorListView;
    private ListAdapter mListAdapter;
    private StepsDBHelper mStepsDBHelper;
    private ArrayList<DateStepsModel> mStepCountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorListView = (ListView)findViewById(R.id.steps_list);

        getDataForList();

        mListAdapter = new ListAdapter(mStepCountList,this);
        mSensorListView.setAdapter(mListAdapter);

        Intent mStepsIntent = new Intent(getApplicationContext(), StepsService.class);
        startService(mStepsIntent);

    }

    private void getDataForList() {
        mStepsDBHelper = new StepsDBHelper(this);
        mStepCountList = mStepsDBHelper.readStepsEntries();
    }

    }