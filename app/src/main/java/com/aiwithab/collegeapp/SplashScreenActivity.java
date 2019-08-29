package com.aiwithab.collegeapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    TextView tvSplashClgName;
    ImageView ivSplash;
    ProgressBar splashProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_activity);
        tvSplashClgName=findViewById(R.id.tvSplashClgName);
        tvSplashClgName.getText();

        ivSplash=findViewById(R.id.ivSplash);
        ivSplash.getDrawable();

        splashProgressBar=(ProgressBar) findViewById(R.id.splashProgressBar);
        splashProgressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK,android.graphics.PorterDuff.Mode.SRC_IN);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
