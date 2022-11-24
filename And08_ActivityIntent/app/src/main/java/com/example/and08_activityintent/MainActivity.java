package com.example.and08_activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout ln_layout, ln_layout2;
    Button btn_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ln_layout = findViewById(R.id.ln_layout);
        ln_layout2 = findViewById(R.id.ln_layout2);
        btn_new = findViewById(R.id.btn_new);

        // xml 파일 붙이기 : LayoutInflater
        // 레이아웃을 붙이는 처리를 하면(= 레이아웃 인플레이션) xml 에 있는 내용이 메모리에 올라가면서
        // 메모리에 올라간 모든 니용을 View 타입으로 return 해줌.
        // return 해준 View 타입을 활용해서 위젯을 찾는 작업을 한다.
        LayoutInflater inflater = getLayoutInflater();  // OS 에서 레이아웃을 붙이는 기능을 가진 객체를 줌
        View v1 = inflater.inflate(R.layout.layout_sub1, ln_layout, true);    // 추후 false
        View v2 = inflater.inflate(R.layout.layout_sub2, ln_layout2, true);

        /*TextView sub_text1 = v1.findViewById(R.id.sub_text1);
        sub_text1.setText("텍스트 글씨!");

        Button sub_btn1 = v1.findViewById(R.id.sub_btn1);
        sub_btn1.setText("버튼 글씨!");*/

        // Q. v2에 있는 위젯을 활용하여 v2에 있는 버튼을 클릭하면 v2의 텍스트 변경 처리하기
        Button sub_btn2 = v2.findViewById(R.id.sub_btn2);
        TextView sub_text2 = v2.findViewById(R.id.sub_text2);
        sub_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub_text2.setText("오늘은 춥다.");
                // Q2. 버튼을 클릭 했을 때 토스트 메세지가 나오게 처리해보기
                // ※ 여기서 그냥 this 는 View ★★★
                // ※ MainActivity.this 라고 써야 함
                Toast.makeText(MainActivity.this, "getLayoutInflater", Toast.LENGTH_SHORT).show();
                NoneContext nc = new NoneContext(getLayoutInflater());
                nc.method01();
                nc.showToast(MainActivity.this);
                nc.v1Seting(v1);
            }
        });
        // ※ context ※
        // Context : 현재 화면에 떠있는 객체에게 어떤 기능을 사용할 수 있는 권한을 줌
        // Context <= Activity 를 넘겨주면된다.
        Toast.makeText(this, "2번", Toast.LENGTH_SHORT).show();

        btn_new.setOnClickListener(new View.OnClickListener() {
            // ※ Intent ※ : 통신 담당
            // Intent <= Activity 전환 ★★★
            @Override
            public void onClick(View v) {
                // MainActivity -> Intent -> SubActivity
                // 현재 액티비티에서 인텐트라는 객체를 통해 다음 액티비티를 띄우기
                //                        (현재 액티비티, 다음 액티비티 클래스)
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                MemberDTO dto = new MemberDTO("sv1","sv2","sv3");
                ArrayList<MemberDTO> list = new ArrayList<>();
                for(int i=0;i<10;i++){
                    list.add(new MemberDTO("sv1","sv2","sv3"));
                }

                // 자바 Map 과 유사한 putExtra(key, value)
                intent.putExtra("sVal","KMJ");// 화면 전환 전, 데이터 넘기기
                // Q. SubActivity 로 int 값 100을 보내고 SubActivity 에서 받아보기
                intent.putExtra("iVal",100);
                // Q. MemberDTO 를 하나 생성해서 Intent 를 통해 전송해보기
                intent.putExtra("dto",dto);
                intent.putExtra("list",list);

                startActivity(intent);  // startActivity <- AppCompatActivity 를 상속 받은 액티비티만 사용가능

            }
        });
    }//onCreate()
}