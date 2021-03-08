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

public class pedometer1 extends AppCompatActivity implements SensorEventListener {
    private TextView textviewstepcounter,textviewstepdetector;
    private SensorManager sensorManager;
    private Sensor mStepCounter,mStepDetector;
    private Boolean iscountersensorpresent,isdetectorsensorpresent;
    int stepcount=0,stepdetect=0;
    Button button;
    private TextView textview,textview1;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textviewstepcounter = (TextView) findViewById(R.id.textView);
        textviewstepdetector = (TextView) findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
       textview=(TextView)findViewById(R.id.stepscount);
        textview1=(TextView)findViewById(R.id.stepsdetect);
        img=(ImageView)findViewById(R.id.save);
        button=(Button)findViewById(R.id.button);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
            mStepCounter=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            iscountersensorpresent=true;
        }
        else{
            textviewstepcounter.setText("counter sensor not present");
            iscountersensorpresent=false;

        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null) {
            mStepDetector=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isdetectorsensorpresent=true;
        }
        else{
            textviewstepcounter.setText("detector sensor not present");
            isdetectorsensorpresent=false;
        }
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg=textviewstepdetector.getText().toString();
                String msg1=textviewstepcounter.getText().toString();
                SharedPreferences shrd=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor=shrd.edit();
                editor.putString("str",msg);
                editor.putString("str1",msg1);
                editor.apply();
                textview1.setText(msg);
                textview.setText(msg1);
            }
        });
        SharedPreferences getShared=getSharedPreferences("demo",MODE_PRIVATE);
        String value= getShared.getString("str","walk");
        String value1= getShared.getString("str1","walk1");
        textview1.setText(value);
        textview.setText(value1);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor==mStepCounter){
            stepcount=(int) sensorEvent.values[0];
            textviewstepcounter.setText(String.valueOf(stepcount));
        }
        else if(sensorEvent.sensor==mStepDetector){
            stepdetect= (int) (stepdetect+sensorEvent.values[0]);
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
            sensorManager.registerListener(this,mStepCounter,SensorManager.SENSOR_DELAY_NORMAL);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
            sensorManager.registerListener(this,mStepDetector,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null)
            sensorManager.unregisterListener(this,mStepCounter);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) != null)
            sensorManager.unregisterListener(this,mStepDetector);
    }


    public void record(View view) {
        Intent intent =new Intent(this,recordpedometer.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent=new Intent(this,dashboard.class);
        startActivity(intent);
    }

    public void records(View view) {
        Intent intent=new Intent(this,recordpedometer.class);
        startActivity(intent);
    }
}

/*public class pedometer1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer1);
    }*/
