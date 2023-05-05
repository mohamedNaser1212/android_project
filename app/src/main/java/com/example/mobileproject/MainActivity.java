package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
//    private static final String TAG = "MainActivity";
//    MyReceiver myReceiver = new MyReceiver();
    EditText name,email,pass,passConf;
    SharedPreferences sharedPreferences;
    Button savebtn;
    private static final String SHARED_PREFERENCE_NAME="mypref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=findViewById(R.id.editTextTextPersonName);
        email=findViewById(R.id.edittextemail);
        pass=findViewById(R.id.passwordEditText);
        passConf=findViewById(R.id.confirm_password);
        savebtn=findViewById(R.id.button);
        sharedPreferences=getSharedPreferences(SHARED_PREFERENCE_NAME,MODE_PRIVATE);
        String namestr=sharedPreferences.getString(KEY_NAME,null);
        if(namestr!=null ){
            Intent intent=new Intent(MainActivity.this,recycle.class);
            startActivity(intent);
//            Toast.makeText(MainActivity.this,"passw",Toast.LENGTH_SHORT).show();



        }

        savebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
if (name.getText().toString().isEmpty()||email.getText().toString().isEmpty()){
    Toast.makeText(MainActivity.this,"fields are empty",Toast.LENGTH_SHORT).show();
} else if (!pass.getText().toString().equals(passConf.getText().toString())) {
    Toast.makeText(MainActivity.this,"passwords are not matching",Toast.LENGTH_SHORT).show();
} else {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(KEY_NAME,name.getText().toString());
    editor.putString(KEY_EMAIL,email.getText().toString());
    editor.apply();
    Intent intent=new Intent(MainActivity.this,recycle.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(intent);

    Toast.makeText(MainActivity.this,"Loginedin succesfully",Toast.LENGTH_SHORT).show();



}






            }
        });





    }
}