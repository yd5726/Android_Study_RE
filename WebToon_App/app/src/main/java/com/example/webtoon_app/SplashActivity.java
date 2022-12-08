package com.example.webtoon_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {
    ImageView splash_gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        /*getSupportActionBar().hide();*/

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("데이터 로딩");
        dialog.setMessage("로딩중....");
        dialog.setCancelable(false);
        dialog.show();

        splash_gif = findViewById(R.id.splash_gif);
        Glide.with(this).load(
                "https://dn-img-page.kakao.com/download/resource?kid=dgy6I8/hzKkWKsECY/B2pzXMu3iMeVVbkTMkqJSk"
        ).into(splash_gif);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);

    }
}