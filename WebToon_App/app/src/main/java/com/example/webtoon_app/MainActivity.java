package com.example.webtoon_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.webtoon_app.home.HomeFragment;
import com.example.webtoon_app.novel.NovelFragment;
import com.example.webtoon_app.webtoon.WebtoonFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    FrameLayout container;
    long pressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);
        changeFragment(new HomeFragment());

        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btm_item1){
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.btm_item2){
                    changeFragment(new WebtoonFragment());
                }else if(item.getItemId() == R.id.btm_item3){
                    changeFragment(new NovelFragment());
                }else if(item.getItemId() == R.id.btm_item4){
                    changeFragment(new HomeFragment());
                }else if(item.getItemId() == R.id.btm_item5){
                    changeFragment(new HomeFragment());
                }
                return true;
            }
        });
    }

    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > pressedTime + 2000){
            pressedTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(), "'뒤로'한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
            //View v = null;
            //writeCustomToast(v);
        }else{
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }
    }
    public void writeCustomToast(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(
                R.layout.custom_toast_layout,
                findViewById(R.id.custom_toast_container));
        TextView text = layout.findViewById(R.id.tv_toast);
        Toast toast = new Toast(this);
        text.setText("토스트 띄우기");
        text.setTextSize(15);
        text.setTextColor(Color.BLACK);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}