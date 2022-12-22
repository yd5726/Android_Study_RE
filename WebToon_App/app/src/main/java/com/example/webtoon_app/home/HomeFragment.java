package com.example.webtoon_app.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.example.webtoon_app.R;
import com.example.webtoon_app.more.MoreActivity_main;
import com.example.webtoon_app.webtoon.WT_Detail_Activity;

public class HomeFragment extends Fragment {
    ImageView WT3H_1;
    Toolbar toolbar;
    ImageButton go_to_up;
    NestedScrollView mScrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        WT3H_1 = v.findViewById(R.id.WT3H_1);
        WT3H_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WT_Detail_Activity.class);
                startActivity(intent);
            }
        });

        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("");

        go_to_up = v.findViewById(R.id.go_to_up);
        mScrollView = v.findViewById(R.id.mScrollView);
        go_to_up.setOnClickListener(v1 -> {
            mScrollView.fullScroll(ScrollView.FOCUS_UP);
        });

        //toolbar.inflateMenu(R.menu.menu_toolbar_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.top_item4:
                        Intent intent = new Intent(getContext(), MoreActivity_main.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        return v;
    }

}