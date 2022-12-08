package com.example.project01_clone.external;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project01_clone.R;

public class ExternalFragment extends Fragment {
    ImageView imgv1, imgv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_external, container, false);

        imgv1 = v.findViewById(R.id.imgv1);
        imgv2 = v.findViewById(R.id.imgv2);
        Glide.with(this).load(
                "https://cdnweb01.wikitree.co.kr/webdata/editor/202103/23/img_20210323144951_67bba4a3.webp"
        ).into(imgv1);
        Glide.with(this).load(
            "https://blog.kakaocdn.net/dn/b7LcY4/btqLpwlD5cW/LCBsdNWknX8CP2Vc0kvguK/img.gif"
        ).into(imgv2);

        return v;
    }
}