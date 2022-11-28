package com.example.and10_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_frag1, btn_frag2;

    // LayoutInflater : 어떤 레이아웃을 따로 불러와서 사용
    // ※ 붙을 공간 => ViewGroup(Layout) ※
    // ※ 붙일 내용 => .xml(Layout) ※
    // 규칙 1) Fragment => ※ 반드시 LayoutInflater 가 있는 상태로 붙음 ※
    // 규칙 2) 반드시 액티비티 안에 있는 형태
    // 만드는 방법 : 패키지 마우스 오른쪽 클릭 후 Fragment 찾기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1 = findViewById(R.id.btn_frag1);
        btn_frag2 = findViewById(R.id.btn_frag2);

        //트랜잭션 : 프로그램 작업단위(프로세스) 다 처리하고, commit

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new MainFragment()).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new SubFragment()).commit();
            }
        });
    }
}