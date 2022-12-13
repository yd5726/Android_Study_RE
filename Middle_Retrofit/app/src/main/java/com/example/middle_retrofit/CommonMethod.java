package com.example.middle_retrofit;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    HashMap<String, Object> params = new HashMap<>();
    public void setParams(String key, String value){
        params.put(key, value);
    }
    public void getData(String url, Callback<String> callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest = apiInterface.getData(url, params);
        apiTest.enqueue(callback);
    }
}
