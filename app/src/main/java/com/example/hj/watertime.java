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
import android.widget.Toast;

public class watertime extends AppCompatActivity {
Button buttontime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watertime);
        createNotificationchannel();
        buttontime=(Button)findViewById(R.id.settime);
        buttontime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(watertime.this, "setted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(watertime.this,ReminderBroadcast.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(watertime.this,0,intent,0);

                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                long timeatbuttonclick=System.currentTimeMillis();
                long tensecondsinmillis=1000*10;
                alarmManager.set(AlarmManager.RTC_WAKEUP,timeatbuttonclick+tensecondsinmillis,pendingIntent);
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
}
