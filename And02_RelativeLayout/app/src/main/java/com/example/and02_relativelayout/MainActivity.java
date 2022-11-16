package com.example.and02_relativelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // context(맥락) : 현재 화면에 보여지는 객체의 상태정보를 의미한다.
        TextView tv = new TextView(this);
        tv.setText("K M J 보여라아아ㅏ아아아ㅏㅏ아아ㅏ아아아ㅏ아ㅏㅏㅏㅇ");
        Button btn = new Button(this);
        btn.setText("자바코드로 버튼 넣음");
        ConstraintLayout layout = new ConstraintLayout(this);
        layout.addView(tv);
        layout.addView(btn);

        //setContentView(R.layout.activity_main);
        setContentView(layout); // ViewGroup <= View 상속
       /* Object obj = null;
        obj = 1;
        obj ="2";
        // obj 는 모든 타입을 담을 수 있는 객체(최상위)
        // Q. 왜 변수 타입을 나눠서 사용할까?
        // Q. Object/String 기능이 누가 더 많을까? String
        //[1] Object
        //[2] String : Object 를 상속받은 자식 객체*/
    }
}