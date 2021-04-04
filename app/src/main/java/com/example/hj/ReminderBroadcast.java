package com.example.hj;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context, "notifyLenubit")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("take water")
                .setContentText("hey user")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());
    }
}
