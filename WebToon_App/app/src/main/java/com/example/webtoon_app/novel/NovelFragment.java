package com.example.webtoon_app.novel;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoon_app.R;
import com.google.android.material.tabs.TabLayout;

public class NovelFragment extends Fragment {
    Toolbar toolbar;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Fragment1 fragment1;
    Fragment2 fragment2;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_novel, container, false);
        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("웹소설");

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        viewPager = v.findViewById(R.id.viewpager_control);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),getLifecycle());
        viewPagerAdapter.addFragment(fragment1);
        viewPagerAdapter.addFragment(fragment2);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setUserInputEnabled(false); //터치 스크롤 막음

        tabLayout = v.findViewById(R.id.mid_tabLayout_test);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                switch (pos){
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        break;
                }
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