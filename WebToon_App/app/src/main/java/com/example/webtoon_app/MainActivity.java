package com.example.webtoon_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.webtoon_app.home.HomeFragment;
import com.example.webtoon_app.novel.NovelFragment;
import com.example.webtoon_app.webtoon.WebtoonFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView btm_nav;
    FrameLayout container;

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
}