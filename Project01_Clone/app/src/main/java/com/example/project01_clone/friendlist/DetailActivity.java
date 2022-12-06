package com.example.project01_clone.friendlist;

import android.app.SearchManager;
import android.content.Intent;
import android.media.tv.TvContentRating;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project01_clone.R;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgv_detail_profile;
    TextView tv_name, tv_msg;
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();   //액션바를 안보이게

        Intent intent = getIntent();
        FriendDTO dto = (FriendDTO) intent.getSerializableExtra("dto");
        imgv_detail_profile = findViewById(R.id.iv_profile);
        tv_name = findViewById(R.id.tv_name);
        tv_msg = findViewById(R.id.tv_msg);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        imgv_detail_profile.setImageResource(dto.getImgRes());
        tv_msg.setText(dto.getMsg());
        tv_name.setText(dto.getName());

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Intent <= 컴포넌트들 간의 통신을 맡고 있는 객체 (액티비티)
        // 1. 명시적 인텐트(우리가 만든 클래스 내부에서 사용하고 그 통제가 전부 가능한 상태)
        //    ex) Intent intent = new Intent(현재 위치(Context), 다음에 띄울 액티비티.class)
        // startActivity 로 끝남
        // 2. 묵시적(암시적) 인텐트 (우리가 만든게 아님, OS나 다른 기타 외부에서 제공하는 기능과 통신(호출)할 때 사용하는 인텐트
        //    우리가 만든게 아니기 때문에 어떤 결과가 나올지 모름
        //    ex) 인터넷 연결, 전화 연결, 카메라, 갤러리, 맵 등
        Intent intent = null;
        if(v.getId() == R.id.btn1){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        }else if(v.getId() == R.id.btn2){
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
        }else if(v.getId() == R.id.btn3){
            // Google 에 검색해서 intent action
            intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY,"searchString");
        }
        startActivity(intent);
    }
}