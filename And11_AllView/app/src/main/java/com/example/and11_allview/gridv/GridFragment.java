package com.example.and11_allview.gridv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.and11_allview.GridF_Adapter;
import com.example.and11_allview.R;

public class GridFragment extends Fragment {
    /*ListView grid_frag;*/
    GridView grid_frag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_grid, container, false);

        grid_frag = v.findViewById(R.id.gridv);

        GridF_Adapter gridF_adapter = new GridF_Adapter(getLayoutInflater());
        grid_frag.setAdapter(gridF_adapter);

        return v;
    }
}