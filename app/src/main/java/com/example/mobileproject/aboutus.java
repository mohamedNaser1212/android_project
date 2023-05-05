package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class aboutus extends AppCompatActivity {
Button btn;
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
btn=findViewById(R.id.personalinfo);

        ImageView openYoutube = findViewById(R.id.openYoutube);
        openYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if (mScheduler != null) {
//                    mScheduler.cancelAll();
//                    mScheduler = null;
//                    Toast.makeText(aboutus.this, "Jobs cancelled", Toast.LENGTH_SHORT).show();
//                }


                mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
                ComponentName serviceName = new ComponentName(getPackageName(),
                        NotificationJobService.class.getName());
                JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, serviceName);
                JobInfo myJobInfo = builder.build();

                mScheduler.schedule(myJobInfo);


                Intent webIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCFVxtgYlCv-TTpWQ9pHaLWQ"));
                try {
                    aboutus.this.startActivity(webIntent);
                } catch (ActivityNotFoundException ex) {
                }
            }
     });
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i =new Intent(aboutus.this,DisplayEmailActivity.class);

    startActivity(i);
    }
});

}
}