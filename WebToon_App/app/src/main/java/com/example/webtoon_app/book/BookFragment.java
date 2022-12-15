package com.example.webtoon_app.book;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.webtoon_app.R;

public class BookFragment extends Fragment {
    Toolbar toolbar;
    Button btn1, btn2;
    BookFragmentActivity1 bookfragmentActivity1;
    BookFragmentActivity2 bookFragmentActivity2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container, false);
        toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle("채팅소설/책");

        btn1 = v.findViewById(R.id.btn1);
        btn2 = v.findViewById(R.id.btn2);

        bookfragmentActivity1 = new BookFragmentActivity1();
        bookFragmentActivity2 = new BookFragmentActivity2();
        getChildFragmentManager().beginTransaction().replace(R.id.frame_layout, bookfragmentActivity1).commit();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.frame_layout, bookfragmentActivity1).commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.frame_layout, bookFragmentActivity2).commit();
            }
        });

        return v;
    }
}