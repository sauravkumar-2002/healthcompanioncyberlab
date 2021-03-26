package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class exercise1 extends AppCompatActivity {
EditText date;
Button button;
ListView listview;
DatabaseHelper databaseHelper;
ArrayList arrayList;
ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        date=(EditText) findViewById(R.id.date2);
        button=(Button)findViewById(R.id.bt_add);
        listview=(ListView)findViewById(R.id.list_view);
        databaseHelper=new DatabaseHelper(exercise1.this);
        arrayList=databaseHelper.getAllText();
        arrayAdapter=new ArrayAdapter(exercise1.this, android.R.layout.simple_list_item_1,arrayList);
        listview.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=date.getText().toString();
                if(!text.isEmpty()){
                    if (databaseHelper.addText(text)){
                        date.setText("");
                        Toast.makeText(getApplicationContext(),"Data Inserted.....",Toast.LENGTH_SHORT).show();
                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getAllText());
                        arrayAdapter.notifyDataSetChanged();
                        listview.invalidateViews();
                        listview.refreshDrawableState();
                    }
                }
            }
        });
    }
}