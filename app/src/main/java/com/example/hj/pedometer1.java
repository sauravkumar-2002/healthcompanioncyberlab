package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class pedometer1 extends AppCompatActivity implements SensorEventListener {

    private TextView textviewstepcounter, textviewstepdetector, dateandtime;
    private SensorManager sensorManager;
    private Sensor mStepCounter, mStepDetector;
    private Boolean iscountersensorpresent, isdetectorsensorpresent;
    int stepcount =0, stepdetect=0 ;
    String saurav, saurav1,saurav2;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    Button button;
    public TextView textview, textview1;
    String Date;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textviewstepcounter = (TextView) findViewById(R.id.textView);
        textviewstepdetector = (TextView) findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        textview = (TextView) findViewById(R.id.stepscount);
        textview1 = (TextView) findViewById(R.id.stepsdetect);
        img = (ImageView) findViewById(R.id.save);
        button = (Button) findViewById(R.id.button);
        dateandtime = (TextView) findViewById(R.id.dateandtime);



        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            iscountersensorpresent = true;
        } else {
            textviewstepcounter.setText("counter sensor not present");
            iscountersensorpresent = false;

        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            mStepDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isdetectorsensorpresent = true;
        } else {
            textviewstepcounter.setText("detector sensor not present");
            isdetectorsensorpresent = false;
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("EEEE,dd-MM-yyyy hh:mm:ss a");
                Date = simpleDateFormat.format(calendar.getTime());
                String msg = textviewstepdetector.getText().toString();
                String msg1 = textviewstepcounter.getText().toString();
                String msg2 = dateandtime.getText().toString();


                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("str", msg);
                editor.putString("str1", msg1);
               editor.putString("str2", msg2);
                editor.apply();
                textview1.setText(msg);
                textview.setText(msg1);
                dateandtime.setText(Date);


            }
        });
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);
        String value = getShared.getString("str", "walk");
        String value1 = getShared.getString("str1", "walk1");
        String value2 = getShared.getString("str2", "walk2");

        textview1.setText(value);
        textview.setText(value1);
      dateandtime.setText(value2);



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {
            stepcount = (int) sensorEvent.values[0];
            textviewstepcounter.setText(String.valueOf(stepcount));
        } else if (sensorEvent.sensor == mStepDetector) {
            stepdetect = (int) (stepdetect + sensorEvent.values[0]);
            textviewstepdetector.setText(String.valueOf(stepdetect));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
            sensorManager.registerListener(this, mStepDetector, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.unregisterListener(this, mStepCounter);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
            sensorManager.unregisterListener(this, mStepDetector);
    }


    public void back(View view) {
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

    public void records(View view) {
        saurav = textview.getText().toString();
        saurav1 = textview1.getText().toString();
        saurav2 = dateandtime.getText().toString();
        Intent intent = new Intent(this, recordpedometer.class);
        intent.putExtra("saurav", saurav);
        intent.putExtra("saurav1", saurav1);
        intent.putExtra("saurav2", saurav2);


        startActivity(intent);

    }


}


