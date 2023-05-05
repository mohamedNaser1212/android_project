package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayEmailActivity extends AppCompatActivity {
    TextView textView_name,textView_email;
    Button button_logout;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREFERENCE_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_email);
        textView_email=findViewById(R.id.text_email);
        textView_name=findViewById(R.id.text_fullname);
        button_logout=findViewById(R.id.btn_logout);
        sharedPreferences=getSharedPreferences(SHARED_PREFERENCE_NAME,MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);
        if(name!=null || email!=null){
            textView_name.setText("welcome:"+name);
            textView_email.setText("email:"+email);
            button_logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                    Intent intent=new Intent(DisplayEmailActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(DisplayEmailActivity.this,"logedout succesfully",Toast.LENGTH_SHORT).show();


                }
            });
        }

    }
}