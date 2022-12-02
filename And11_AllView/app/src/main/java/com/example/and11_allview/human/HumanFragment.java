package com.example.and11_allview.human;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and11_allview.R;
import com.example.and11_allview.myrecycler.MyRecvAdapter;

import java.util.ArrayList;

public class HumanFragment extends Fragment {
    RecyclerView human_recv;
    ArrayList<HumanDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_human, container, false);

        human_recv = v.findViewById(R.id.human_recv);

        human_recv.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        list.add(new HumanDTO("사과", "맛있는 사과를 팝니다.","30,000원", R.drawable.apples_640));
        list.add(new HumanDTO("굴", "맛있는 굴 팝니다.","50,000원", R.drawable.oysters_640));
        list.add(new HumanDTO("홍합", "맛있는 홍합 팝니다.","35,000원", R.drawable.shellfish_640));
        list.add(new HumanDTO("꼬막", "맛있는 꼬막 팝니다.","20,000원", R.drawable.shell_640));
        list.add(new HumanDTO("배추", "맛있는 배추 팝니다.","100,000원", R.drawable.cabbage_640));
        list.add(new HumanDTO("무", "맛있는 무 팝니다.","200,000원", R.drawable.white_radish_640));
        list.add(new HumanDTO("늙은호박", "맛있는 늙은호박 팝니다.","10,000원", R.drawable.pumpkin_640));
        list.add(new HumanDTO("대하", "맛있는 대하 팝니다.","40,590원", R.drawable.shrimp_640));
        list.add(new HumanDTO("유자", "맛있는 유자 팝니다.","10,600원", R.drawable.citron_640));
        list.add(new HumanDTO("명태", "맛있는 명태 팝니다.","12,000원", R.drawable.pollock_640));

        human_recv.setAdapter(new HumanAdapter(getLayoutInflater(),list));
        return v;
    }
}