package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class exercise1 extends AppCompatActivity {
EditText date;
TextView endtime;
TextView starttime;
Button button;
Button button1;
//Button refreshh;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String datee;



   /*RecyclerView recyclerView1;
    ArrayList<model> dataholder;
    ArrayList<model> olddataholder;
    // public List<model> dataholder;
    RecyclerView.Adapter adapter1;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        date = (EditText) findViewById(R.id.date2);
        endtime = (TextView) findViewById(R.id.endtime1);

        starttime = (TextView) findViewById(R.id.startime1);
      //  olddataholder=new ArrayList<>();
        //olddataholder.addAll(dataholder);
       // refreshh=(Button)findViewById(R.id.bt_refresh);





     /*   recyclerView1=(RecyclerView)findViewById(R.id.recview);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        dataholder = new ArrayList<>();

        Cursor cursor=new dbmanager(this).readalldata();
        while (cursor.moveToNext()){
            model obj=new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);
        }
        adapter1= new myadapterex(dataholder);
        // myadapterex adapter=new myadapterex(dataholder);
        recyclerView1.setAdapter(adapter1);*/

button1=(Button)findViewById(R.id.bt_record);
        button = (Button) findViewById(R.id.bt_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("EEEE,dd-MM-yyyy hh:mm:ss a");
                datee = simpleDateFormat.format(calendar.getTime());
                starttime.setText(datee);
                processinsert(date.getText().toString(),starttime.getText().toString(),endtime.getText().toString());

            }
        });

button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(),fetchdata.class);
        startActivity(intent);
        //startActivity(new Intent(getApplicationContext(),fetchdata.class));
    }
});
    }

    private void processinsert(String d, String s, String e) {
        String res=new dbmanager(this).addrecord(d,s,e);
        date.setText("");
        starttime.setText("");
        endtime.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {
    }
}