package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void pedometer(View view) {
        Intent intent=new Intent(this,pedometer1.class);
        startActivity(intent);
    }

    public void exercise(View view) {
        Intent intent=new Intent(this,exercise1.class);
        startActivity(intent);
    }

    public void water(View view) {
        Intent intent=new Intent(this,water1.class);
        startActivity(intent);
    }
}