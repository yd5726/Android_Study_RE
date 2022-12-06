package com.example.project01_clone.friendlist;

import android.content.Context;
import android.content.Intent;
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
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.KmjViewHoder> {
    //3
    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context){
        this.inflater = inflater;
        this.list = list;
        this.context = context;
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
    public void onBindViewHolder(@NonNull KmjViewHoder holder, int i) {
        holder.iv_profile.setImageResource(list.get(i).getImgRes());
        holder.tv_name.setText(list.get(i).getName());
        holder.tv_msg.setText(list.get(i).getMsg());
        // 지정한 위치에 xml 붙이는 것 : 인플리에이트 (inflater.inflate())
        // ※ 액티비티를 띄울 때 꼭 필요한 것(현재 화면의 정보) ==> Context ※ ★★★
        // Context 는 일반 클래스라서 바로 접근할 수 없다. <<= 화면에 나오는 클래스로부터 받아옴
        // ※ 꼭 필요한 것 : 통신을 통해 액티비티를 띄우게 하는 객체 ==> Intent ※
        final int idx = i;
        holder.iv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(v.getContext(),DetailActivity.class);
                //startActivity(intent);
                // 화면에 나오는 것 : Class
                // 프래그먼트 : 반드시 액티비티를 거쳐서 붙어있음
                // ↑ 두 개의 화면에 나오는 클래스로부터 받아올 수 있는 정보 (Context)
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("dto",list.get(idx));   // i가 변하지 않는 값임을 나타내자 ★★★
                context.startActivity(intent);
            }
        });
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
