package com.example.and05_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);     // TextView 초기화 (디자인<=연결=>Java)
        tv.setText("글씨 SET TEXT");    // 기존 글자를 없애고 새로운 글자를
        tv.append("글씨 append");       // 기존글자 += 새로운 글자
        // Q. 화면 영역보다 글자가 더 많게끔 반복처리 해보기
        for(int i=0;i<50;i++){
            tv.append("\n반복"+i+"글씨 SET TEXT글씨 SET TEXT글씨 SET TEXT글씨 SET TEXT글씨 SET TEXT글씨 SET TEXT글씨 SET TEXT");
        }//for


    }
}