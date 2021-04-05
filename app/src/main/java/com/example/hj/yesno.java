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

public class yesno extends AppCompatActivity {
Button yeswatertaken;
Button nowatertaken,gotorecords,setnewtime;
EditText dateandtimewater;
TextView glass;
    Calendar calendar;
    SimpleDateFormat simpleDateFormatwater,simpledate;
    String datee,noofglass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesno);
        glass=(TextView)findViewById(R.id.waterglass);
        dateandtimewater=(EditText)findViewById(R.id.datewater);
        nowatertaken=(Button)findViewById(R.id.nowater);
        yeswatertaken=(Button)findViewById(R.id.yeswater);
        gotorecords=(Button)findViewById(R.id.gotorecordwater);
        gotorecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),water1.class);
                startActivity(intent);
            }
        });
        setnewtime=(Button)findViewById(R.id.setnewtime);
        setnewtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),watertime.class);
                startActivity(intent);
            }
        });
        yeswatertaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
              //  simpleDateFormatwater = new SimpleDateFormat("'  Ending Time: 'HH:mm:ss ");
                simpledate=new SimpleDateFormat("dd.MM.yyyy ' At 'HH:mm:ss ");
                datee = simpledate.format(calendar.getTime());
                dateandtimewater.setText(datee);
                glass.setText("1 Glass");
                processinsert(dateandtimewater.getText().toString(),glass.getText().toString());
yeswatertaken.setVisibility(View.GONE);
nowatertaken.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"You Have Taken Your Water",Toast.LENGTH_SHORT).show();
            }
            });
        nowatertaken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                //  simpleDateFormatwater = new SimpleDateFormat("'  Ending Time: 'HH:mm:ss ");
                simpledate=new SimpleDateFormat("dd.MM.yyyy ' At 'HH:mm:ss ");
                datee = simpledate.format(calendar.getTime());
                dateandtimewater.setText(datee);
                glass.setText("0 Glass");
                processinsert(dateandtimewater.getText().toString(),glass.getText().toString());
                yeswatertaken.setVisibility(View.GONE);
                nowatertaken.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"You Have Not Taken Your Water",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void processinsert(String d,String s) {
        String res=new dbmanagerwater(this).addrecord(d,s);
        dateandtimewater.setText("");
       glass.setText("");

        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}