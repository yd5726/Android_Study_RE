package com.example.webtoon_app.novel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoon_app.R;
import com.google.android.material.tabs.TabLayout;

public class NovelFragment extends Fragment {
    Toolbar toolbar;
    //TabLayout mid_tabLayout;
    ViewPager mid_viewpager;
    PagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_novel, container, false);
        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("웹소설");

        TabLayout mid_tabLayout = v.findViewById(R.id.mid_tabLayout);
        /*mid_tabLayout.addTab((mid_tabLayout.newTab().setText("one")));
        mid_tabLayout.addTab((mid_tabLayout.newTab().setText("two")));
        mid_tabLayout.addTab((mid_tabLayout.newTab().setText("three")));
        mid_tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);*/
        pagerAdapter = new PagerAdapter(getChildFragmentManager(),mid_tabLayout.getTabCount());
        mid_viewpager = v.findViewById(R.id.mid_viewpager);
        mid_viewpager.setAdapter(pagerAdapter);
        mid_viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mid_tabLayout));

        mid_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mid_viewpager.setCurrentItem(tab.getPosition());
                pagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return v;
    }
}