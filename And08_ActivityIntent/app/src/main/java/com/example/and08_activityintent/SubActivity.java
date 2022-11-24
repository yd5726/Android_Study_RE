package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // new 안 함
        Intent intent = getIntent();    // MainActivity 에서 SubActivity 를 띄울 때 통신용으로 사용한 intent
        String sVal = intent.getStringExtra("sVal");
        Log.d("로그", "값 : " + sVal);
        int iVal = intent.getIntExtra("iVal",-1);   // int 타입은 null 을 사용 못해서, default 값 -1 지정 필요
        Log.d("로그", "값 : " + iVal);

        MemberDTO dto = (MemberDTO)intent.getSerializableExtra("dto");
        Log.d("로그", "값 : "+ dto.getsVal1());

        ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)intent.getSerializableExtra("list");
        Log.d("로그", "값 : "+list.size());
    }
}