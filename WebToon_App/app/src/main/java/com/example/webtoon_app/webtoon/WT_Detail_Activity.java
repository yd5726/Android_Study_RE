package com.example.webtoon_app.webtoon;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.webtoon_app.MainActivity;
import com.example.webtoon_app.R;
import com.example.webtoon_app.home.HomeFragment;

public class WT_Detail_Activity extends AppCompatActivity {
    /*ImageView iv_back_btn;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.vertical_enter, R.anim.none);
        setContentView(R.layout.activity_webtoon_detail);

        //overridePendingTransition();
        /*iv_back_btn = findViewById(R.id.iv_back_btn);
        iv_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.none, R.anim.vertical_exit);
    }

}