package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
Button snoozesleep,stopsleep11,gotosleep1,setalarmnew,snoozesleep2,stopsleep22;
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
        snoozesleep2=(Button)findViewById(R.id.snooze2);
        stopsleep11=(Button)findViewById(R.id.stopsleep);
        stopsleep22=(Button)findViewById(R.id.stopsleep2);
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
                simpledate1=new SimpleDateFormat("dd.MM.yyyy ' You Woke Up At 'HH:mm:ss a");
                dateesleep = simpledate1.format(calendar1.getTime());
                datesleep.setText(dateesleep);
                statussleep.setText("perfect");
                processinsert(datesleep.getText().toString(),statussleep.getText().toString());
              //  snoozesleep.setVisibility(View.GONE);
               // stopsleep11.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"You Have Turned off Your Alarm",Toast.LENGTH_SHORT).show();
stopsleep11.setVisibility(View.GONE);
snoozesleep.setVisibility(View.GONE);
snoozesleep2.setVisibility(View.GONE);
stopsleep22.setVisibility(View.GONE);
            }
        });
        snoozesleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              AlarmManager  alarmManager1=(AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent=new Intent(snoozestop.this,ReminderBroadcastsleep.class);
              PendingIntent  pendingIntent1= PendingIntent.getBroadcast(snoozestop.this,0,intent,0);
              alarmManager1.set(AlarmManager.RTC_WAKEUP,Calendar.getInstance().getTimeInMillis()+10*60000,pendingIntent1);
                Toast.makeText(getApplicationContext(),"Alarm Snoozed For 10 min",Toast.LENGTH_SHORT).show();
                stopsleep11.setVisibility(View.GONE);
                stopsleep22.setVisibility(View.VISIBLE);
                snoozesleep.setVisibility(View.GONE);
                snoozesleep2.setVisibility(View.VISIBLE);
            }
        });
        snoozesleep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager  alarmManager1=(AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intent=new Intent(snoozestop.this,ReminderBroadcastsleep.class);
                PendingIntent  pendingIntent1= PendingIntent.getBroadcast(snoozestop.this,0,intent,0);
                alarmManager1.set(AlarmManager.RTC_WAKEUP,Calendar.getInstance().getTimeInMillis()+10*60000,pendingIntent1);
                Toast.makeText(getApplicationContext(),"Alarm Snoozed For More 10 min",Toast.LENGTH_SHORT).show();
                stopsleep11.setVisibility(View.GONE);
                stopsleep22.setVisibility(View.VISIBLE);
                snoozesleep2.setVisibility(View.GONE);
                snoozesleep.setVisibility(View.GONE);
            }
        });
        stopsleep22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar1 = Calendar.getInstance();
                //  simpleDateFormatwater = new SimpleDateFormat("'  Ending Time: 'HH:mm:ss ");
                simpledate1=new SimpleDateFormat("dd.MM.yyyy ' You Woke Up At 'HH:mm:ss a");
                dateesleep = simpledate1.format(calendar1.getTime());
                datesleep.setText(dateesleep);
                statussleep.setText("Imperfect - OVERSLEPT");
                processinsert(datesleep.getText().toString(),statussleep.getText().toString());
                //  snoozesleep.setVisibility(View.GONE);
                // stopsleep11.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"You Have Turned off Your Alarm2",Toast.LENGTH_SHORT).show();
                snoozesleep2.setVisibility(View.GONE);
                stopsleep22.setVisibility(View.GONE);
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