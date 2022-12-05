package com.example.project01_clone.friendlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;
import java.util.Random;

public class FriendFragment extends Fragment {
    RecyclerView recv_friend_frag;
    ArrayList<FriendDTO> list = new ArrayList<>();

    int[] imgArr ={
            R.drawable.profile_img1,
            R.drawable.profile_img2,
            R.drawable.profile_img3,
            R.drawable.profile_img4,
            R.drawable.profile_img5,
            R.drawable.profile_img6,
            R.drawable.profile_img7,
            R.drawable.profile_img8
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend, container, false);

        for(int i=0; i<30; i++){
            list.add(new FriendDTO(imgArr[new Random().nextInt(imgArr.length)], "이름"+(i+1),"메시지"+(i+1)));
        }

        recv_friend_frag = v.findViewById(R.id.recv_friend_frag);
        recv_friend_frag.setAdapter(new FriendAdapter(inflater, list));
        recv_friend_frag.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}