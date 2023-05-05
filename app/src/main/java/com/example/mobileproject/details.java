package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;
    Button btn;
    TextView status;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extra =getIntent().getExtras();

        button= findViewById(R.id.backButton);
        btn= findViewById(R.id.contactus);
        textView = findViewById(R.id.carName);
        imageView = findViewById(R.id.carImage);
        status=findViewById(R.id.carStatus);
        description=findViewById(R.id.description);

        int x= Constants.contArr.get(Integer.parseInt(extra.get("position").toString())).image;
        imageView.setImageResource(x);

        textView.setText(extra.get("name").toString());
        status.setText(extra.get("status").toString());
        description.setText(extra.get("desc").toString());

        button.setOnClickListener((v -> finish()
                ));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(details.this,aboutus.class);

                startActivity(i);
            }
        });
}

}