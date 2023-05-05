package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.util.Log;

public class splashactivity extends AppCompatActivity {
    private static final String TAG = "RecieverMain";
    MyReceiver myReceiver = new MyReceiver();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashactivity);
        Timer myTimer = new Timer();


        Log.d(TAG, "onCreate: Registering receiver");

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction(Intent.ACTION_BATTERY_OKAY);
        registerReceiver(myReceiver, intentFilter);
        Log.d(TAG, "onCreate: Registered receiver");


        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                openLoginScreen();
            }
        }, 2000);



    }

    private void openLoginScreen() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}