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
    int stepcount = 0, stepdetect = 0;
    String saurav, saurav1, saurav2;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat1;
    Button button;
    public TextView textviewstepcount, textview1stepdetect;
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
        textviewstepcount = (TextView) findViewById(R.id.stepscount);
        textview1stepdetect = (TextView) findViewById(R.id.stepsdetect);
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
                simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
                Date = simpleDateFormat1.format(calendar.getTime());


                textview1stepdetect.setText(textviewstepdetector.getText().toString());
                textviewstepcount.setText(textviewstepcounter.getText().toString());
                dateandtime.setText(Date);
                processinsert(dateandtime.getText().toString(), textviewstepcount.getText().toString(), textview1stepdetect.getText().toString());

                Toast.makeText(getApplicationContext(), "Time Recorded You can see Your Records", Toast.LENGTH_SHORT).show();





            }
        });

    }

    private void processinsert(String d, String s, String e) {
        String res = new dbmanagerpedo(this).addrecord1(d, s, e);
        dateandtime.setText("");
        textviewstepcount.setText("");
        textview1stepdetect.setText("");
        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mStepCounter) {
            stepcount = (int) sensorEvent.values[0];
            textviewstepcounter.setText(String.valueOf(stepcount));
            textviewstepcount.setText(String.valueOf(stepcount));
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
      /*  saurav = textview.getText().toString();
        saurav1 = textview1.getText().toString();
        saurav2 = dateandtime.getText().toString();
        Intent intent = new Intent(this, recordpedometer.class);
        intent.putExtra("saurav", saurav);
        intent.putExtra("saurav1", saurav1);
        intent.putExtra("saurav2", saurav2);
        startActivity(intent);
       */
        Intent intent = new Intent(this, recordpedometer.class);
        startActivity(intent);

    }


}


