package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class water1 extends AppCompatActivity {
    RecyclerView recyclerViewwater;
    ArrayList<modelwater> dataholderwater;
    // public List<model> dataholder;
    RecyclerView.Adapter adapterwater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water1);
        recyclerViewwater=(RecyclerView)findViewById(R.id.recviewwater);
        recyclerViewwater.setLayoutManager(new LinearLayoutManager(this));
        dataholderwater = new ArrayList<>();
        Cursor cursor=new dbmanagerwater(this).readalldata();
        while (cursor.moveToNext()){
            modelwater objwater=new modelwater(cursor.getString(1),cursor.getString(2));
            dataholderwater.add(objwater);
        }
        adapterwater= new myadapterwater(dataholderwater);
        // myadapterex adapter=new myadapterex(dataholder);
        recyclerViewwater.setAdapter(adapterwater);
    }

    public void time(View view) {
        Intent intent=new Intent(this,watertime.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent=new Intent(this,dashboard.class);
        startActivity(intent);
    }
}