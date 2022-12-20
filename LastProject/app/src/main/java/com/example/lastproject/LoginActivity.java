package com.example.lastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_id, edt_pw;
    ImageView imgv_kakao_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        imgv_kakao_login = findViewById(R.id.imgv_kakao_login);

        new CommonMethod();
        ApiClient.setBASEURL("http://192.168.0.122:8080/middle/");
        // Kakao SDK 초기화 - 네이티브 앱 키
        KakaoSdk.init(this, "9ecf3920e593ae8182b60e4f97200009");

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(edt_id.getText().toString().equals("admin") && edt_pw.getText().toString().equals("admin_pw")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                */
                new CommonMethod().setParams("email", edt_id.getText().toString())
                        .setParams("pw", edt_pw.getText().toString())
                        .sendPost("login.me", new CommonMethod.CallBackResult() {
                            @Override
                            public void result(boolean isResult, String data) {
                                Log.d("로그", "result:" + data);
                            }
                        });
                getHashKey();
            }//onClick

            //     +OcnZOF3HQbUUdlZpB+vOZ93WZQ=
            private void getHashKey(){
                PackageInfo packageInfo = null;
                try {
                    packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                if (packageInfo == null)
                    Log.e("로그", "KeyHash:null");

                for (Signature signature : packageInfo.signatures) {
                    try {
                        MessageDigest md = MessageDigest.getInstance("SHA");
                        md.update(signature.toByteArray());
                        Log.d("로그", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                    } catch (NoSuchAlgorithmException e) {
                        Log.e("로그", "Unable to get MessageDigest. signature=" + signature, e);
                    }
                }
            }

        });

        imgv_kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaoLogin();
            }
        });
    }//onCreate

    private void kakaoLogin(){
        // 카카오계정으로 로그인
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Log.d("로그", "invoke: "+oAuthToken.toString());
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                            Log.d("로그", "invoke: " + user.getId());
                            Log.d("로그", "invoke: " + user.getKakaoAccount().getEmail());
                            Log.d("로그", "invoke: " + user.getKakaoAccount().getProfile().getNickname());
                            Log.d("로그", "invoke: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());

                            socialLogin(user.getKakaoAccount().getEmail());

                            return null;
                        }
                    });
                }
                return null;
            }
        };

        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)){
            UserApiClient.getInstance().loginWithKakaoTalk(this, callback);
        }else{
            UserApiClient.getInstance().loginWithKakaoAccount(this, callback);
        }

    }//kakaoLogin

    public void socialLogin(String email){
        // 소셜 로그인을 통해서 가져온 정보를 Spring 으로 전송하기
        // AndMemberController 에서 받게 처리
           //user.getKakaoAccount().getEmail();
        //Log.d("로그", "socialLogin: "+ user.getKakaoAccount().getEmail());
        Log.d("로그", "socialLogin: " + email);
        new CommonMethod().setParams("email",email).sendPost("social.me", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {

            }
        });

        // 1. 가입한 정보가 있다면 로그인 성공 처리
        // 2. 가입한 정보가 없다면 회원가입 처리
    }//socialLogin
}