package com.example.and07_res;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    final String TAG = "로그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.kmj_act);
        //setContentView(R.layout.dimen_act);
        setContentView(R.layout.kakao_act);

        //Log.d(TAG, "리소스 값 : " + R.string.app_version);              // 숫자
        //Log.d(TAG, "리소스 값 : " + getString(R.string.app_version));   // 문자열
    }
}