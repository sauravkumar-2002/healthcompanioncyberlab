package com.example.hj;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recordpedometer extends AppCompatActivity {


    RecyclerView recyclerViewpedo;
    ArrayList<modelpedo> dataholderpedo;

    RecyclerView.Adapter adapterpedo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordpedometer);


        recyclerViewpedo = (RecyclerView) findViewById(R.id.rclviewpedo);
        recyclerViewpedo.setLayoutManager(new LinearLayoutManager(this));
        dataholderpedo = new ArrayList<>();
        Cursor cursor = new dbmanagerpedo(this).readalldata();
        while (cursor.moveToNext()) {
            modelpedo objpedo = new modelpedo(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholderpedo.add(objpedo);
        }
        adapterpedo = new myadapterpedo(dataholderpedo);

        recyclerViewpedo.setAdapter(adapterpedo);


    }

    public void back(View view) {
        Intent intent = new Intent(this, pedometer1.class);
        startActivity(intent);
    }
}