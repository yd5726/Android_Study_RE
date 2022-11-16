package com.example.temp_delete;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//접근제한자, 클래스 이름, 상속, 상속받은 클래스
    // public : 접근제한자
public class MainActivity extends AppCompatActivity {
/* 오버라이드 vs 오버라이딩★*/
    // 오버라이드 : 재정의 (이미 구현되어있는 부모클래스 내용을 다시 정의해서 쓰는 것)
    // 오버로딩 : 메소드의 이름을 같게하고 파라메터 타입이나 갯수를 달리해서 사용하는 것
// 생성하겠다 : onCreate()
// 접근제한자, 리턴 타입, 메소드 이름, 파라메타
    // protected : 상속을 받아야지만 재정의를 허용함
// super 키워드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test test = new Test(); // 인스턴스화
        test.iV1 = 10;
        test.iV2 = 20;

        //Test.sV1 = 10; // 메모리에 이미 올라가있는 변수이기때문에 인스턴스화를 통해서
        // 객체를 다시 한 번 메모리에 올리고 사용할 필요가 없다.

        //1
        Test.Sub sub = test.new Sub();
        sub.sub_v1 = "hello";
        sub.subMethod();

        //2
        Test.sSub sSub1 = new Test.sSub();
        Test.sSub.subV2 = 1;
        Test.sSub.subMethod2();

        sSub1.subV1 = "go";
        sSub1.subMethod();
    }
}