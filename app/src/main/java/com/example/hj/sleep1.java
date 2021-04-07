package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class sleep1 extends AppCompatActivity {
  // TextView currentsleeptime,calculatedtime;
   // EditText enterher;
    Button addsleep,btncancelalarm;
    String result;
    RecyclerView recyclerViewsleep;
    ArrayList<modelsleep> dataholdersleep;
    // public List<model> dataholder;
    RecyclerView.Adapter adaptersleep;
    Calendar calendar2,calendar3;
    TimePicker timePicker;
    AlarmManager alarmManager1;
    PendingIntent pendingIntent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep1);
        recyclerViewsleep=(RecyclerView)findViewById(R.id.recviewsleep1);
        recyclerViewsleep.setLayoutManager(new LinearLayoutManager(this));
        dataholdersleep = new ArrayList<>();
        Cursor cursor=new dbmanagersleep(this).readalldata();
        while (cursor.moveToNext()){
            modelsleep objsleep=new modelsleep(cursor.getString(1),cursor.getString(2));
            dataholdersleep.add(objsleep);
        }
        adaptersleep= new myadaptersleep(dataholdersleep);
        // myadapterex adapter=new myadapterex(dataholder);
        recyclerViewsleep.setAdapter(adaptersleep);
        timePicker=(TimePicker)findViewById(R.id.timepickersleep);










       createNotificationchannel();

        addsleep=(Button)findViewById(R.id.buttonsavehr1);
btncancelalarm=(Button)findViewById(R.id.buttoncancel);
        alarmManager1=(AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent=new Intent(sleep1.this,ReminderBroadcastsleep.class);
        pendingIntent1=PendingIntent.getBroadcast(sleep1.this,0,intent,0);
        addsleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                Calendar startTime1=Calendar.getInstance();
                startTime1.set(Calendar.HOUR_OF_DAY,hour);
                startTime1.set(Calendar.MINUTE,minute);
                startTime1.set(Calendar.SECOND,0);
                Toast.makeText(sleep1.this, " Alarm setted", Toast.LENGTH_SHORT).show();



                long alarmsettime1=startTime1.getTimeInMillis();
                alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP,alarmsettime1,AlarmManager.INTERVAL_DAY,pendingIntent1);
                addsleep.setVisibility(View.GONE);
                btncancelalarm.setVisibility(View.VISIBLE);
            }  });
        btncancelalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
alarmManager1.cancel(pendingIntent1);
                Toast.makeText(sleep1.this, " Alarm Cancelled", Toast.LENGTH_SHORT).show();
btncancelalarm.setVisibility(View.GONE);
addsleep.setVisibility(View.VISIBLE);
            }
        });




}

    private void createNotificationchannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence namesleep = "LenubitReminderChannel";
            String descriptionsleep = "channel for Lenubit Reminder";
            int importancesleep = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLenubit", namesleep, importancesleep);
            channel.setDescription(descriptionsleep);

            NotificationManager notificationManagersleep = getSystemService(NotificationManager.class);
            notificationManagersleep.createNotificationChannel(channel);
        }
    }
}