package com.example.and11_allview.myrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

//2번
public class MyRecvAdapter extends RecyclerView.Adapter<MyRecvAdapter.ViewHolder>{
    //3번-1
    LayoutInflater inflater;
    //3번-2
    public MyRecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }
    //3번-4
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_myrecf_myrecv, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    //5번-2
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.music_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.tv_music_title.setText("시간의 지평선");
        holder.tv_music_writer.setText("윤하(YOUNHA)");
    }

    //4번
    @Override
    public int getItemCount() {
        return 15;
    }

    //1번
    public class ViewHolder extends RecyclerView.ViewHolder{
        //5번-1
        ImageView tv_music_img;
        TextView tv_music_rank, tv_music_title, tv_music_writer;
        Button music_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_music_img = itemView.findViewById(R.id.tv_music_img);
            tv_music_rank = itemView.findViewById(R.id.tv_music_rank);
            tv_music_title = itemView.findViewById(R.id.tv_music_title);
            tv_music_writer = itemView.findViewById(R.id.tv_music_writer);
            music_btn = itemView.findViewById(R.id.music_btn);
        }
    }

    // 6번
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
