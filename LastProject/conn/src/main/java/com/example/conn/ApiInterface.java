package com.example.conn;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    // POST 방식
    @FormUrlEncoded
    @POST
    Call<String> connPost(@Url String url, @FieldMap HashMap<String, Object> params);

    // GET 방식
    @GET("{path}")
    Call<String> connGet(@Path("path") String url, @QueryMap HashMap<String, Object> params);
}
