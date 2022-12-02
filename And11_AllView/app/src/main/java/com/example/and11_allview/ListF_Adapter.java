package com.example.and11_allview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListF_Adapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<ListFDTO> list;

    public ListF_Adapter(LayoutInflater layoutInflater, ArrayList<ListFDTO> list) {
        this.layoutInflater = layoutInflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View v, ViewGroup root) {
        v = layoutInflater.inflate(R.layout.item_main_listv,root,false);
        /*TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_txt = v.findViewById(R.id.tv_txt);
        tv_name.setText(list.get(i).getName());
        tv_txt.setText(list.get(i).getTxt());*/

        TextView tv_name = v.findViewById(R.id.tv_name);
        TextView tv_txt = v.findViewById(R.id.tv_txt);
        ImageView img_title = v.findViewById(R.id.img_title);

        ListFDTO dto = list.get(i);
        int resId = dto.getPoster();
        String name = dto.getName();
        String txt = dto.getTxt();
        tv_name.setText(name);
        tv_txt.setText(txt);
        img_title.setImageResource(resId);

        return v;
    }
}
