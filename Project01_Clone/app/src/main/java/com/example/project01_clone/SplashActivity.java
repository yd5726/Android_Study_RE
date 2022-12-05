package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    // Splash 화면 : 사용자에게 자연스럽게 광고 배너나 브랜드 이미지를 노출 시킴으로
    // 브랜드의 이미지를 친근하게 만들고 부각 시킴. 또는 해당하는 이미지를 노출하는 동안
    // 백그라운드에서는 데이터 로딩 작업을 할 수 있음.
    // Handler : <= 메인 쓰레드를 이용해서 딜레이를 주는 기능을 이용할 때 사용.
    // 화면에 앱이 보여주는 액티비티의 순서나 등록된 모든 컴포넌트 관리 : AndroidManifest.xml
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // ProgressDialog : 사용자 입장에서 중요한 UI 요소 ※
        // 사용자는 현재 앱이 멈춘건지 아니면 데이터 로딩을 위해서 시간이 소요되는지
        // 판단을 할 수가 없음 : 빈번하게 많이 사용됨
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("KMJ TALK 데이터 로딩");
        dialog.setMessage("로딩중....");
        dialog.setCancelable(false);
        dialog.show(); // <= 실제로 화면에 보이게 만드는 메소드

        // 3가지 방법 : 쓰레드, RunOnUiThread, Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(SplashActivity.this, "5초 지남", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                // Activity 가 전환 ==> 통신 ==> Intent
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },1000 * 5);

    }
}