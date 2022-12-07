package com.example.project01_clone.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.friendlist.FriendDTO;

import java.util.ArrayList;
import java.util.Random;

public class ChatFragment extends Fragment {
    RecyclerView recv_chat_frag;
    ArrayList<FriendDTO> list;

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
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new FriendDTO(imgArr[new Random().nextInt(imgArr.length)],"대화 이름"+(i+1),"대화 메세지"+(i+1)));
        }

        recv_chat_frag = v.findViewById(R.id.recv_chat_frag);
        recv_chat_frag.setAdapter(new ChatAdapter(inflater, list, getContext()));
        recv_chat_frag.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        return v;
    }
}