package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Log.d(TAG, "onReceive: Airplane mode changed");
                Intent anotherIntent = new Intent(context, MainActivity2.class);
                context.startActivity(anotherIntent);
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Log.d(TAG, "onReceive: Power connected");
                break;

        }
    }
}
