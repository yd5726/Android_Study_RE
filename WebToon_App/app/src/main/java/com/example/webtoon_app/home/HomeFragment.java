package com.example.webtoon_app.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.webtoon_app.R;
import com.example.webtoon_app.webtoon.WT_Detail_Activity;

public class HomeFragment extends Fragment {
    ImageView banner1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        banner1 = v.findViewById(R.id.banner1);
        banner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), WT_Detail_Activity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}