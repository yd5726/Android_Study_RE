package com.example.and11_allview.recycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;

public class RecyclerFragment extends Fragment {
    RecyclerView recv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        recv = v.findViewById(R.id.recv);
        recv.setAdapter(new RecvAdapter(inflater));

        // ※ 리사이클러 뷰는 가로 뷰와 세로 뷰(Orientation)을 제공함. LayoutManager 가 필요함. ※
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext() , RecyclerView.VERTICAL, false
                /*getContext() , RecyclerView.HORIZONTAL, false*/
        );
        recv.setLayoutManager(manager);

        return v;
    }
}