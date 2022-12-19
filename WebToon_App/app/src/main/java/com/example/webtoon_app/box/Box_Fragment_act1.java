package com.example.webtoon_app.box;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoon_app.R;
import com.example.webtoon_app.novel.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Box_Fragment_act1 extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_box__act1, container, false);
        recyclerView = v.findViewById(R.id.box_recv);
        recyclerView.setAdapter(new BoxAdapter(inflater, getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}