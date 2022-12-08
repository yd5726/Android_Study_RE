package com.example.project01_clone.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder>{
    LayoutInflater inflater;

    public ViewAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView view_icon, view_baner;
        TextView view_id, view_timeLog, view_mainTitle, view_subTitle1, view_subTitle2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_icon = itemView.findViewById(R.id.view_icon);
            view_baner = itemView.findViewById(R.id.view_baner);
            view_id = itemView.findViewById(R.id.view_id);
            view_timeLog = itemView.findViewById(R.id.view_timeLog);
            view_mainTitle = itemView.findViewById(R.id.view_mainTitle);
            view_subTitle1 = itemView.findViewById(R.id.view_subTitle1);
            view_subTitle2 = itemView.findViewById(R.id.view_subTitle2);
        }
    }
}
