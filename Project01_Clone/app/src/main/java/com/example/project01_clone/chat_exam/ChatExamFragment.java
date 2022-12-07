package com.example.project01_clone.chat_exam;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.example.project01_clone.common.CommonMethod;

import java.util.ArrayList;

public class ChatExamFragment extends Fragment {
    RecyclerView recv_exam_chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_exam, container, false);
        recv_exam_chat = v.findViewById(R.id.recv_exam_chat);

        ArrayList<ChatExamDTO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ChatExamDTO(
                    R.drawable.profile_img3,
                    "이름"+(i+1),
                    "메시지"+(i+1),
                    "12:30"
            ));
        }

        // 와일드 카드..?
        //ArrayList<?> list1 = new ArrayList<>();
        //list1.add(...);

        ChatExamAdapter adapter = new ChatExamAdapter(inflater, list , getContext());
        recv_exam_chat.setAdapter(adapter);
        // 메소드로
        /*LinearLayoutManager manager = new LinearLayoutManager(
                getContext(), RecyclerView.VERTICAL, false
        );
        recv_exam_chat.setLayoutManager(manager);*/
        /*recv_exam_chat.setLayoutManager(CommonMethod.getManager(getContext()));*/
        recv_exam_chat.setLayoutManager(CommonMethod.getManager(getContext(), RecyclerView.VERTICAL));

        return v;
    }
}