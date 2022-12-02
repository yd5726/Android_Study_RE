package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.and11_allview.gridv.GridFragment;
import com.example.and11_allview.human.HumanFragment;
import com.example.and11_allview.listfrag.ListFragment;
import com.example.and11_allview.myrecycler.MyRecyclerFragment;
import com.example.and11_allview.recycler.RecyclerFragment;

public class MainActivity extends AppCompatActivity {
    Button btn_sub, btn_listF, btn_grid, btn_recycler, btn_recycler_my, btn_human;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sub = findViewById(R.id.btn_sub);
        btn_listF = findViewById(R.id.btn_listF);
        btn_grid = findViewById(R.id.btn_grid);
        btn_recycler = findViewById(R.id.btn_recycler);
        btn_recycler_my = findViewById(R.id.btn_recycler_my);
        btn_human = findViewById(R.id.btn_human);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 복습 ★★★
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });

        btn_listF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 복습 ★★★
                /*Fragment fragment = new ListFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();*/
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
            }
        });

        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new GridFragment()).commit();
            }
        });

        btn_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecyclerFragment()).commit();
            }
        });

        btn_recycler_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyRecyclerFragment()).commit();
            }
        });

        btn_human.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new HumanFragment()).commit();
            }
        });
    }
}