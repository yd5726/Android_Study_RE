package com.example.and01_helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /*옵저버 <= 관찰자, 감시자

    옵저버 패턴 : 인터페이스를 활용해서 각종 위젯의
    변경상태를 감지해서 개발자에게 알려주는 형식

    xml 에서 열린 태그는 반드시(대부분) 자바의 객체로 존재한다.
    ex) ConstraintLayout, Button*/
    Button btn; // <= 어떤 객체를 선언만 한 상태 <= null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // <= activity_main.xml <=> java 코드 연결

        btn = findViewById(R.id.btn); // new 를 사용 x, 디자인에 있는 위젯을 찾아서 연결(초기화 식)
        // View.OnClickListener <= Q. 인터페이스를 넘겨라?
        // [1] 인터페이스를 new 로 바로 파라메터로 넘기는 방식 - 인터페이스도 클래스다?
        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 익명의 지역
            }
        });*/
        //[2] 인터페이스를 미리 new 로 생성해놓고 사용하는 방식
        /*View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        btn.setOnClickListener(clickListener);*/
        // [3] 직접 상속 받아서 나 자신을 이용하는 방식
        // implements View.OnClickListener
        btn.setOnClickListener(this);
    }
    public void onClick(View v){
        // syso <= x
        Log.d("이름","버튼이 클릭 됨");
        // Q. 버튼을 클릭하면 1 ~ 50까지의 수 중 홀수의 수를 로그로 출력하기
        for(int i=1;i<=50;i++){
            if(i%2 != 0){
                Log.d("i값","i값 : " + i); // ctrl + p : 들어갈 자료형 확인
                // 어떤 변수 + String Type = String
                // int(1) + int(2) + String = 3
                // int(1) + String + int(2) = 12
            }
        }
    }
}