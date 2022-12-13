package com.example.middle_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.middle_retrofit.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding; //<= 위젯을 하나씩 find 안해도 하나로 묶어놓음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        // Retrofit.create()
        CommonMethod commonMethod = new CommonMethod();
        //String url = "andVo";
        //commonMethod.getData(url);
        commonMethod.setParams("data","KMJ");
        commonMethod.getData("andVo", new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "성공: "+ response.body());
                CustomerVO vo = new Gson().fromJson(response.body(),CustomerVO.class);
                binding.tv.setText(vo.getEmail());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "실패: "+ t.getMessage());
            }
        });

        /*
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        HashMap<String, Object> params = new HashMap<>();
        params.put("id","admin"); //<= 스프링에서 받아서 출력해보기
        //Call<String> apiTest = apiInterface.getData("andTest", params);
        //Call<String> apiTest = apiInterface.getData("and_customer", params);
        Call<String> apiTest = apiInterface.getData("andVo", params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("로그", "응답 : " + response.body());
                // And => Spring 으로 데이터 요청 => Spring 응답 => And(Data==String)
                //        List<Customer> => String =>
                //        String => List<Customer>

                //List<CustomerVO> list = new Gson().fromJson(
                //        response.body(), new TypeToken<List<CustomerVO>>(){}.getType()
                //);
                //Log.d("로그", "onResponse: "+list.size());

                CustomerVO vo = new Gson().fromJson(response.body() ,CustomerVO.class);
                Log.d("로그", "onResponse: " + vo.getEmail());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("로그", "응답 실패: ");
            }
        });
        */
    }
}