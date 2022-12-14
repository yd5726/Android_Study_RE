package com.example.webtoon_app.webtoon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    public VPAdapter(@NonNull FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        items.add(new WT_Detail_Fragment1());
        items.add(new WT_Detail_Fragment2());
        items.add(new WT_Detail_Fragment3());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
