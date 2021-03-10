package com.example.hj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recordpedometer extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    public List<Listitem> listItems;
    String str1, str2,str3;
    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordpedometer);

Intent intent=getIntent();
str1=intent.getStringExtra("saurav");
str2=intent.getStringExtra("saurav1");
str3=intent.getStringExtra("saurav2");




        recyclerView = (RecyclerView) findViewById(R.id.rclview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();


for(int i=0;i<100;i++) {


    Listitem listItem = new Listitem(
            str1,
            str2,
            str3);

    listItems.add(listItem);
}

      //  listItems.add(new Listitem(str1,str2,str3));
      /* Listitem listitem=new Listitem(
                str1,str2,str3
        );
        listItems.add(listitem);*/

        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

    }

    public void back(View view) {
        Intent intent = new Intent(this, pedometer1.class);
        startActivity(intent);
    }
}