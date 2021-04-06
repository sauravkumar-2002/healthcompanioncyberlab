package com.example.hj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

    public void sleeping1(View view) {
        Intent intent=new Intent(this,sleep1.class);
        startActivity(intent);
    }

    public void logout(View view) {
        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("remember", "false");
        editor.apply();
        Intent intent=new Intent(this,login.class);
        startActivity(intent);
        finish();

    }
}