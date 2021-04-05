package com.example.hj;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newIntent=new Intent(context,yesno.class);
        PendingIntent contentIntent=PendingIntent.getActivity(context,0,newIntent,0);
       // NotificationManager mynotificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context, "notifyLenubit")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Take Water")
                .setWhen(System.currentTimeMillis())
                .setContentText("Tap for More")
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setAutoCancel(true);
        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());
    }
}
