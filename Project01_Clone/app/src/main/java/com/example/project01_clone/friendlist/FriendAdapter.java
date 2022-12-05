package com.example.project01_clone.friendlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

//2
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.KmjViewHoder>{
    //3
    LayoutInflater inflater;
    ArrayList<FriendDTO> list;

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list){
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public KmjViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_friend, parent, false);
        KmjViewHoder kmjViewHoder = new KmjViewHoder(v);

        return kmjViewHoder;
    }

    //5
    @Override
    public void onBindViewHolder(@NonNull KmjViewHoder holder, int position) {
        holder.iv_profile.setImageResource(list.get(position).getImgRes());
        holder.tv_name.setText(list.get(position).getName());
        holder.tv_msg.setText(list.get(position).getMsg());
    }

    //4
    @Override
    public int getItemCount() {
        return 10;
    }

    //1
    public class KmjViewHoder extends RecyclerView.ViewHolder{
        ImageView iv_profile;
        TextView tv_name, tv_msg;
       public KmjViewHoder(@NonNull View itemView) {
           super(itemView);
           iv_profile = itemView.findViewById(R.id.iv_profile);
           tv_name = itemView.findViewById(R.id.tv_name);
           tv_msg = itemView.findViewById(R.id.tv_msg);
       }
   }
}
