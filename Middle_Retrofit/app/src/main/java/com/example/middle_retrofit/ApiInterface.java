package com.example.middle_retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    // get 또는 post 등 여러가지 방식의 요청을 미리 지정해놓고
    // 계속해서 새로 초기화해서 사용함

    @FormUrlEncoded // URL 을 가변적으로 바꾸서 요청 받게 처리(mapping)
    @POST // 요청방식 POST
    Call<String> getData(@Url String url, @FieldMap HashMap<String, Object> params);

   /*public interface GitHubService {
        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String user);
    }*/
}
