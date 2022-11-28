package com.example.and10_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SubFragment extends Fragment {
    Button btn_sub_frag, btn_imgViewControl;
    ImageView imgView1,imgView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sub, container, false);
        btn_sub_frag = v.findViewById(R.id.btn_sub_frag);
        btn_sub_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"fragment_sub",Toast.LENGTH_SHORT).show();
            }
        });

        btn_imgViewControl = v.findViewById(R.id.btn_imgViewControl);
        imgView1 = v.findViewById(R.id.imgView1);
        imgView2 = v.findViewById(R.id.imgView2);

        btn_imgViewControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imgView1.getVisibility() == View.VISIBLE){
                    imgView1.setVisibility(View.GONE);
                    imgView2.setVisibility(View.VISIBLE);
                }else if(imgView2.getVisibility() == View.VISIBLE){
                    imgView2.setVisibility(View.GONE);
                    imgView1.setVisibility(View.VISIBLE);
                }
            }
        });

        return v;
    }
}