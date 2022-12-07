package com.example.project01_clone.common;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommonMethod {

    public static LinearLayoutManager getManager(Context context){
        LinearLayoutManager manager = new LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
        );
        return manager;
    }

    public static LinearLayoutManager getManager(Context context, int orientation){
        LinearLayoutManager manager = new LinearLayoutManager(
                context, orientation, false
        );
        return manager;
    }
}
