package com.example.conn;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    HashMap<String, Object> params = new HashMap<>();
    /*
    public void setParams(String key, String value){
        params.put(key, value);
    }
    */
    public CommonMethod setParams(String key, String value){
        params.put(key, value);
        return this;
    }

    //POST 방식
    public void sendPost(String url, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connPost(url, params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // <= 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }

    //GET 방식
    public void sendGet(String url, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connGet(url, params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace(); // <= 어떤 오류인지 로그에 찍히게 처리
            }
        });
    }
    /*
    public void sendGet(String url, Callback<String> callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.connGet(url, params);
        apiTest.enqueue(callback);
    }
    */
    // 1. 정의
    public interface CallBackResult{
        // 메인에서 CommonMethod 를 통해서 Callback<String> 인터페이스를 넘겨서 실행할 때마다
        // 두 개의 메소드가 오버라이드 됨. (onResponse, onFailure) => 하나로 합치고 싶음.
        public void result(boolean isResult, String data);
    }
}
