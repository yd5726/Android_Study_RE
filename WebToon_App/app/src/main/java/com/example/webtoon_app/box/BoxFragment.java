package com.example.webtoon_app.box;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoon_app.R;
import com.example.webtoon_app.novel.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class BoxFragment extends Fragment {
    Toolbar toolbar;
    ViewPager2 viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Box_Fragment_act1 box_fragment_act1;
    Box_Fragment_act2 box_fragment_act2;
    Box_Fragment_act3 box_fragment_act3;
    Box_Fragment_act4 box_fragment_act4;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_box, container, false);
        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("보관함");

        box_fragment_act1 = new Box_Fragment_act1();
        box_fragment_act2 = new Box_Fragment_act2();
        box_fragment_act3 = new Box_Fragment_act3();
        box_fragment_act4 = new Box_Fragment_act4();

        viewPager = v.findViewById(R.id.viewpager_control);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPagerAdapter.addFragment(box_fragment_act1);
        viewPagerAdapter.addFragment(box_fragment_act2);
        viewPagerAdapter.addFragment(box_fragment_act3);
        viewPagerAdapter.addFragment(box_fragment_act4);

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
                    case 2:
                        viewPager.setCurrentItem(2);
                        break;
                    case 3:
                        viewPager.setCurrentItem(3);
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