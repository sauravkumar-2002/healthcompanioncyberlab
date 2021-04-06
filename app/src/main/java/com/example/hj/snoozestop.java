package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class snoozestop extends AppCompatActivity {
Button snoozesleep,stopsleep11,gotosleep1,setalarmnew;
TextView statussleep;
EditText datesleep;
    Calendar calendar1;
    SimpleDateFormat simpleDateFormatwater,simpledate1;
    String dateesleep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snoozestop);
        snoozesleep=(Button)findViewById(R.id.snooze);
        stopsleep11=(Button)findViewById(R.id.stopsleep);
        gotosleep1=(Button)findViewById(R.id.gotorecordsleep);
        setalarmnew=(Button)findViewById(R.id.setnewalarmsleep);
        statussleep=(TextView)findViewById(R.id.statussleep1);
        datesleep=(EditText) findViewById(R.id.datesleep1);
        gotosleep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),sleep1.class);
                startActivity(intent);
            }
        });
        stopsleep11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar1 = Calendar.getInstance();
                //  simpleDateFormatwater = new SimpleDateFormat("'  Ending Time: 'HH:mm:ss ");
                simpledate1=new SimpleDateFormat("dd.MM.yyyy ' At 'HH:mm:ss ");
                dateesleep = simpledate1.format(calendar1.getTime());
                datesleep.setText(dateesleep);
                statussleep.setText("perfect");
                processinsert(datesleep.getText().toString(),statussleep.getText().toString());
              //  snoozesleep.setVisibility(View.GONE);
               // stopsleep11.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"You Have Taken Your Water",Toast.LENGTH_SHORT).show();
            }
        });

}

    private void processinsert(String n, String c) {
        String res=new dbmanagersleep(this).addrecord(n,c);
        datesleep.setText("");
        statussleep.setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}