package com.example.hj;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recordpedometer extends AppCompatActivity {


private RecyclerView recyclerView;
private RecyclerView.Adapter adapter;
private List<Listitem> listItems;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recordpedometer);


  recyclerView=(RecyclerView)findViewById(R.id.rclview);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    listItems=new ArrayList<>();
    for(int i=0; i<1000; i++){
        Listitem listItem=new Listitem(
                "Heading "+(i+1),
                "dummy text");
        listItems.add(listItem);
    }

    adapter=new MyAdapter(listItems,this);
    recyclerView.setAdapter(adapter);

}
}