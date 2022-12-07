package com.example.project01_clone.chat_exam;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class ChatExamAdapter extends RecyclerView.Adapter<ChatExamAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<ChatExamDTO> list;
    Context context;

    public ChatExamAdapter(LayoutInflater inflater, ArrayList<ChatExamDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_examchat, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    // 바인딩 ! ★★★
    // ViewHolder(데이터 한 칸을 저장해놓은 DTO 화면에 보이는 요소) <==> ArrayList 의 데이터 연결 처리
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.tv_chat_name.setText(list.get(i).getChat_name());
        holder.tv_chat_msg.setText(list.get(i).getChat_msg());
        holder.tv_chat_date.setText(list.get(i).getChat_date());
        holder.l_layout_exam_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context1 = v.getContext();

                /*Intent intent = new Intent(context, ChatExamActivity.class);*/
                Intent intent = new Intent(context1, ChatExamActivity.class);   // 무슨 문제가..??
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_chat_profile;
        TextView tv_chat_name, tv_chat_msg, tv_chat_date;
        LinearLayout l_layout_exam_chat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgv_chat_profile = itemView.findViewById(R.id.imgv_chat_profile);
            tv_chat_name = itemView.findViewById(R.id.tv_chat_name);
            tv_chat_msg = itemView.findViewById(R.id.tv_chat_msg);
            tv_chat_date = itemView.findViewById(R.id.tv_chat_date);
            l_layout_exam_chat = itemView.findViewById(R.id.l_layout_exam_chat);
        }
    }
}
