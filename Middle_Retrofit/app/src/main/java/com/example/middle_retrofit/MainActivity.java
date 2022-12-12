package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrofit.create()
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        HashMap<String, Object> params = new HashMap<>();
        params.put("id","admin"); //<= 스프링에서 받아서 출력해보기
        Call<String> apiTest = apiInterface.getData("andTest", params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "일단 응답옴: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "응답 실패: ");
            }
        });
    }
}