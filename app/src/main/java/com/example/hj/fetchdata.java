package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class fetchdata extends AppCompatActivity {
    RecyclerView recyclerView1;
    ArrayList<model> dataholder;
  // public List<model> dataholder;
     RecyclerView.Adapter adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetchdata);
        recyclerView1=(RecyclerView)findViewById(R.id.recview);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        dataholder = new ArrayList<>();
        Cursor cursor=new dbmanager(this).readalldata();
        while (cursor.moveToNext()){
            model obj=new model(cursor.getString(2),cursor.getString(3),cursor.getString(1));
            dataholder.add(obj);
        }
        adapter1= new myadapterex(dataholder);
        // myadapterex adapter=new myadapterex(dataholder);
        recyclerView1.setAdapter(adapter1);
    }

    public void back(View view) {
    }
}