package com.example.webtoon_app.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.webtoon_app.R;

public class BookFragmentActivity1 extends Fragment {
    TextView card_banner_main, card_banner_sub;
    TextView card_3banner_item1, card_3banner_item2, card_3banner_item3, card_3banner_item4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bookfragment_activity1, container, false);

        card_banner_main = v.findViewById(R.id.card_banner_main);
        card_banner_sub = v.findViewById(R.id.card_banner_sub);
        card_banner_main.setText("3시간마다 무료!");
        card_banner_sub.setText("새로워진 기다무, 3다무를 만나보세요");

        card_3banner_item1 = v.findViewById(R.id.card_3banner_item1);
        card_3banner_item2 = v.findViewById(R.id.card_3banner_item2);
        card_3banner_item3 = v.findViewById(R.id.card_3banner_item3);
        card_3banner_item4 = v.findViewById(R.id.card_3banner_item4);
        card_3banner_item1.setText("채팅소설 신작");
        card_3banner_item2.setText("");
        card_3banner_item3.setText("30분기다무");
        card_3banner_item4.setText("12월 라인업");


        return v;
    }
}