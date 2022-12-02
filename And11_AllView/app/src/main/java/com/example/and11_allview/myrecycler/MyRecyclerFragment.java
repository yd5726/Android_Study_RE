package com.example.and11_allview.myrecycler;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;
import com.example.and11_allview.recycler.RecvAdapter;

public class MyRecyclerFragment extends Fragment {
    RecyclerView myrecv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_recycler, container, false);
        myrecv = v.findViewById(R.id.myrecv);
        myrecv.setAdapter(new MyRecvAdapter(inflater));
        myrecv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}