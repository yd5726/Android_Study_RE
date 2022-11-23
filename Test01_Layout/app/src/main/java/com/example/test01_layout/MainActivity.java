package com.example.test01_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_change;
    ImageView img_view1,img_view2;
    int count = 0;
    ArrayList<ImageView> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_change = findViewById(R.id.btn_change);
        img_view1 = findViewById(R.id.img_view1);
        img_view2 = findViewById(R.id.img_view2);

        imgList.add(findViewById(R.id.img_view1));
        imgList.add(findViewById(R.id.img_view2));

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0){
                    img_view1.setVisibility(View.GONE);
                    img_view2.setVisibility(View.VISIBLE);
                    count = 1;
                }else if(count == 1){
                    img_view2.setVisibility(View.GONE);
                    img_view1.setVisibility(View.VISIBLE);
                    count = 0;
                }
            }
        });
    }
}