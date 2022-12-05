package com.example.project01_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.project01_clone.friendlist.FriendFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView btm_nav;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        actionBar = getSupportActionBar();  // 기본으로 있는 액션바를 가져옴.
        actionBar.setTitle("친구");
        changeFragment(new FriendFragment());

        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.btm_item1){
                    actionBar.setTitle("친구");
                    // Q.
                    // 패키지 추가 => friendlist
                    // FriendFragment 추가
                    // 해당하는 프래그먼트가 붙게 처리
                    /*getSupportFragmentManager().beginTransaction().replace(R.id.container, new FriendFragment()).commit();*/
                    changeFragment(new FriendFragment());
                }else if(item.getItemId() == R.id.btm_item2){
                    actionBar.setTitle("채팅");
                }else if(item.getItemId() == R.id.btm_item3){
                    actionBar.setTitle("뷰");
                }else if(item.getItemId() == R.id.btm_item4){
                    actionBar.setTitle("쇼핑");
                }else if(item.getItemId() == R.id.btm_item5){
                    actionBar.setTitle("더보기");
                }
                return true;    // 선택을 취소함
            }
        });
    }//onCreate()

    // 프레그먼트를 changeFragment() 메소드를 이용해서 동적으로 붙이는 처리
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}