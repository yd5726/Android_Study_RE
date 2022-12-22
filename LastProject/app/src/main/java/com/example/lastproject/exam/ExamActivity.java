package com.example.lastproject.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // IP 설정
        ApiClient.setBASEURL("http://192.168.0.122:8080/middle/");

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        // 람다식
        btn1.setOnClickListener(v -> {
            new CommonMethod().sendPost("test1", new CommonMethod.CallBackResult() {
                @Override
                public void result(boolean isResult, String data) { // data : Spring 에서 return 을 줘야만 있는 부분
                    Log.d("로그", "isResult: " + isResult);
                    Log.d("로그", "data: " + data);   // return 안줬으니 data 값 출력 x
                }
            });
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().setParams("id","yd5726")
                        .setParams("pw","5726yd")
                        .setParams("email","yd5726@naver.com")
                        .sendPost("test2", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {

                    }
                });
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPost("test3", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        Log.d("로그", "result: " + data);
                    }
                });
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPost("test4", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        Log.d("로그", "result: " + data);
                        // new Gson().fromJson(바꾸고 싶은 데이터, 바꾸고 싶은 타입)
                        TestVO testVO = new Gson().fromJson(data, TestVO.class);
                        Log.d("로그", "result: "+testVO.getiVal());
                        Log.d("로그", "result: "+testVO.getsVal());
                        Log.d("로그", "result: "+testVO.getdVal());
                    }
                });
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonMethod().sendPost("test5", new CommonMethod.CallBackResult() {
                    @Override
                    public void result(boolean isResult, String data) {
                        Log.d("로그", "result: " + data);
                        ArrayList<TestVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<TestVO>>(){}.getType());
                        Log.d("로그", "list.size() result: " + list.size());
                    }
                });
            }
        });
    }
}