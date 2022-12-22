package com.example.lastproject.customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    RecyclerView recv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        // IP 설정 <= 안드로이드 시작점에서 한번만 해주기
        ApiClient.setBASEURL("http://192.168.0.122:8080/middle/");

        recv = findViewById(R.id.recv);
        selectList();
        /*
        new CommonMethod().sendPost("select.cu", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d("로그", "result: " + data);
                //List<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());

                ArrayList<CustomerVO> list  = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
                recv.setAdapter(new CustomerAdapter(getLayoutInflater(),list,CustomerActivity.this));
                // 공통으로 옮길 것
                recv.setLayoutManager(new LinearLayoutManager(CustomerActivity.this,RecyclerView.VERTICAL,false));
            }
        });
        */

        /*
        recv.setAdapter(new CustomerAdapter(getLayoutInflater()));
        // 공통으로 옮길 것
        recv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
         */
    }

    public void selectList(){
        new CommonMethod().sendPost("select.cu", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d("로그", "result: " + data);
                //List<CustomerVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());

                ArrayList<CustomerVO> list  = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
                recv.setAdapter(new CustomerAdapter(getLayoutInflater(),list,CustomerActivity.this));
                // 공통으로 옮길 것
                recv.setLayoutManager(new LinearLayoutManager(CustomerActivity.this,RecyclerView.VERTICAL,false));
            }
        });
    }
}