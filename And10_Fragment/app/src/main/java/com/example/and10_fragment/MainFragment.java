package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainFragment extends Fragment {
    Button btn_main_frag;
    MainActivity activity;

    /*public MainFragment(MainActivity activity){
        this.activity = activity;
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        btn_main_frag = v.findViewById(R.id.btn_main_frag);
        btn_main_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Q. 토스트 창
                // 방법 1
                Toast.makeText(getContext(), "fragment_main", Toast.LENGTH_SHORT).show();
                // 방법 2
                //Toast.makeText(activity, "", Toast.LENGTH_SHORT).show();
            }
        });

        //inflate : 레이아웃을 붙인다.
        return v;
    }

}