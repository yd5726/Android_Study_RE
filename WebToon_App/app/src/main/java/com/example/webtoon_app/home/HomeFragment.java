package com.example.webtoon_app.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.webtoon_app.R;
import com.example.webtoon_app.webtoon.WT_Detail_Activity;

public class HomeFragment extends Fragment {
    ImageView WT3H_1;
    Toolbar toolbar;

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

        return v;
    }

}