package com.example.and11_allview.human;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

import java.util.ArrayList;

//2.
public class HumanAdapter extends RecyclerView.Adapter<HumanAdapter.HumanViewHolder>{
    LayoutInflater inflater;
    ArrayList<HumanDTO> list;

    public HumanAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public HumanAdapter(LayoutInflater inflater, ArrayList<HumanDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    //3.
    @NonNull
    @Override
    public HumanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_humanf_humanv, parent, false);
        HumanViewHolder humanViewHolder = new HumanViewHolder(v);

        return humanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HumanViewHolder h, int i) {
        /*h.human_title.setText("사과");
        h.human_txt.setText("맛있는 밀양 얼음골 사과 팝니다.");
        h.human_price.setText("50,000원");*/
        h.human_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        ImageView human_img = h.itemView.findViewById(R.id.human_img);
        TextView human_title = h.human_title.findViewById(R.id.human_title);
        TextView human_txt = h.human_txt.findViewById(R.id.human_txt);
        TextView human_price = h.human_price.findViewById(R.id.human_price);

        HumanDTO humanDTO = list.get(i);
        int resId = humanDTO.getPoster();
        human_img.setImageResource(resId);
        String title = humanDTO.getHuman_title();
        String txt = humanDTO.getHuman_txt();
        String price = humanDTO.getHuman_price();
        human_title.setText(title);
        human_txt.setText(txt);
        human_price.setText(price);
    }

    //4.
    @Override
    public int getItemCount() {
        return 10;
    }

    //1.
    public class HumanViewHolder extends RecyclerView.ViewHolder{
        //5.
        ImageView human_img;
        TextView human_title,human_txt, human_price;
        public HumanViewHolder(@NonNull View v) {
            super(v);
            human_img = v.findViewById(R.id.human_img);
            human_title = v.findViewById(R.id.human_title);
            human_txt = v.findViewById(R.id.human_txt);
            human_price = v.findViewById(R.id.human_price);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
