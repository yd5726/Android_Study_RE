package com.example.webtoon_app.novel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int num;
    public PagerAdapter(FragmentManager fm, int num){
        super(fm);
        this.num = num;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Novel_Fragment_act1 fragment1 = new Novel_Fragment_act1();
                return fragment1;
            case 1:
                Novel_Fragment_act2 fragment2 = new Novel_Fragment_act2();
                return fragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}
