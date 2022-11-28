package com.example.and09_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class subActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }
}