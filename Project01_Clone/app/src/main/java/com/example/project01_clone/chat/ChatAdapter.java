package com.example.project01_clone.chat;

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
import com.example.project01_clone.friendlist.FriendDTO;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;

    public ChatAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_chat, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv_profile_chat.setImageResource(list.get(position).getImgRes());
        holder.tv_name_chat.setText(list.get(position).getName());
        holder.tv_msg_chat.setText(list.get(position).getMsg());
        final int idx = position;
        holder.l_layout_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailChatActivity.class);
                /*intent.putExtra("dto",list.get(idx));*/
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_profile_chat;
        TextView tv_name_chat, tv_msg_chat;
        LinearLayout l_layout_chat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile_chat = itemView.findViewById(R.id.iv_profile_chat);
            tv_name_chat = itemView.findViewById(R.id.tv_name_chat);
            tv_msg_chat = itemView.findViewById(R.id.tv_msg_chat);
            l_layout_chat = itemView.findViewById(R.id.l_layout_chat);

        }
    }
}
