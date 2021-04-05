package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class watertime extends AppCompatActivity {
Button buttontime;
TimePicker timepiker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watertime);
        createNotificationchannel();
        buttontime=(Button)findViewById(R.id.settime);
        timepiker=(TimePicker)findViewById(R.id.timepicker);
        buttontime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour=timepiker.getCurrentHour();
                int minute=timepiker.getCurrentMinute();
                Calendar startTime=Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                Toast.makeText(watertime.this, "setted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(watertime.this,ReminderBroadcast.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(watertime.this,0,intent,0);

                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                long alarmsettime=startTime.getTimeInMillis();
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,alarmsettime,AlarmManager.INTERVAL_DAY,pendingIntent);
                //alarmManager.set(AlarmManager.RTC_WAKEUP,alarmsettime,pendingIntent);
                //long timeatbuttonclick=System.currentTimeMillis();
                //long tensecondsinmillis=1000*10;
                //alarmManager.set(AlarmManager.RTC_WAKEUP,timeatbuttonclick+tensecondsinmillis,pendingIntent);
        }});


}
    private void createNotificationchannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name="LenubitReminderChannel";
            String description="channel for Lenubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notifyLenubit",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void back(View view) {
        Intent intent=new Intent(getApplicationContext(),water1.class);
        startActivity(intent);
    }
}
