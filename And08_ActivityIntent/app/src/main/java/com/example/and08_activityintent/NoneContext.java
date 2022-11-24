package com.example.and08_activityintent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoneContext {
    LayoutInflater inflater;

    public NoneContext(LayoutInflater inflater){
        this.inflater = inflater;
    }

    public void method01() {
        if (inflater == null) {
            Log.d("인플레이터", "method01: null");
        } else {
            Log.d("인플레이터", "method01: not null");
        }
        // Q. NoneContext.class 에 있는 inflater 호출?
        // method1이 호출되기전 inflater 가 null 이 아니게 만들어보기
        // MainActivity 에서 method01() 호출
    }
    public void showToast(MainActivity activity){
        // Q. NoneContext.class 에서 토스트 메세지를 띄워보기
        //Toast.makeText(MainActivity.this, "getLayoutInflater", Toast.LENGTH_SHORT).show();
        Toast.makeText(activity, "토스트", Toast.LENGTH_SHORT).show();
    }

    public void v1Seting(View v1){
        TextView sub_text1 = v1.findViewById(R.id.sub_text1);
        sub_text1.setText("텍스트 글씨!");

        Button sub_btn1 = v1.findViewById(R.id.sub_btn1);
        sub_btn1.setText("버튼 글씨!");
    }
}
