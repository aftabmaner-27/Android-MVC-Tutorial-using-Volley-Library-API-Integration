package com.aftabmaner_27.androidmvcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.aftabmaner_27.androidmvcproject.Views.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000; // 3 seconds
    String splashname ="test splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
getSupportActionBar().hide();
        // Handler to start the MainActivity after a delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                // Close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}