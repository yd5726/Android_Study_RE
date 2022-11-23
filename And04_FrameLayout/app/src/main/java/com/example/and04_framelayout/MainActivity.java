package com.example.and04_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1 , btn2 ;
    //ImageView imgv1 , imgv2 , imgv3 ; // <=선언 이 이름으로 쓰겟다. null
    // 데이터를 한건보다 많이 넣을수있는 자료구조=>배열 , Collection
    // 이미지뷰 3개를 하나의 내가알고있는 자료구조로 묶어보기.
    ImageView[] imgs = new ImageView[3];// [null] [null] [null]
    ArrayList<ImageView> imgList = new ArrayList<>();
    int cnt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);//↑(xml에 있는 id가 어떤것인것)
        btn2 = findViewById(R.id.btn2);//↑(xml에 있는 id가 어떤것인것)
        imgs[0] = findViewById(R.id.imgv1);
        imgs[1] = findViewById(R.id.imgv2);
        imgs[2] = findViewById(R.id.imgv3);

        imgList.add(findViewById(R.id.imgv1));
        imgList.add(findViewById(R.id.imgv2));
        imgList.add(findViewById(R.id.imgv3));

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        //btn1.setOnClickListener(new KymOnclickListener());
        //내가 만든 클래스 KymOnclickListener가 View.OnClickListener와 같을까? 같음(구조를 전부 가지고있음)
        //같다면 btn1.setOnClickListener의 메소드 파라메터로 이용할수있을까? 이용가능
    }

    public void imgChange(){
        Log.d("로그", "btn2: " + cnt);
        for(int i = 0 ; i < imgList.size() ; i ++){
            imgList.get(i).setVisibility(View.GONE);
        }
        imgList.get(cnt).setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn1){
            cnt--;
            if(cnt==-1) cnt = 2;
        }else if(v.getId() == R.id.btn2){
            cnt++;
            if(cnt==3) cnt = 0;
        }
        imgChange();
    }
}