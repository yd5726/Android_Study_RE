package com.example.lastproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*CommonMethod commonMethod = new CommonMethod();*/
        /*commonMethod.setParams("data","KMJ");*/

        /*
        commonMethod.sendGet("andVo", new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "성공: "+ response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "실패: "+ t.getMessage());
            }
        });
        */
        // 팀 프로젝트 할 때 자기 것으로 바꾸기
        ApiClient.setBASEURL("http://192.168.0.122:8080/middle/");

        // 2. 구현
        new CommonMethod().setParams("data","KMJ").sendGet("andVo", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                if(isResult){
                    Log.d("로그", "result: " + data);
                }
            }
        });
    }
}