package com.example.hj;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcastsleep extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent newIntent=new Intent(context,snoozestop.class);
        PendingIntent contentIntentsleep=PendingIntent.getActivity(context,0,newIntent,0);
        // NotificationManager mynotificationManager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder buildersleep=new NotificationCompat.Builder(context, "notifyLenubit")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("ALARM")
                .setWhen(System.currentTimeMillis())
                .setContentText("Tap for Snooze or Stop")
                .setContentIntent(contentIntentsleep)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        buildersleep.setAutoCancel(true);
        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(context);

        notificationManager.notify(200,buildersleep.build());

       // Uri notification= RingtoneManager.getActualDefaultRingtoneUri(RingtoneManager.TYPE_RINGTONE);
        Ringtone r=RingtoneManager.getRingtone(context,RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        r.play();
    }
}
