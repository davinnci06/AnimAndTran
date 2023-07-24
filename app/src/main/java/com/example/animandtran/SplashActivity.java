package com.example.animandtran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.imageSplash);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000);
        logo.startAnimation(fadeIn);

        logo.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImageView logo = findViewById(R.id.imageSplash);
        logo.removeCallbacks(null);
    }
}