package com.example.webtoon_app.webtoon;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.webtoon_app.R;

public class WebtoonFragment extends Fragment {
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_webtoon, container, false);
        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("웹툰");

        return v;
    }
}