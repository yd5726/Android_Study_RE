package com.example.and11_allview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class GridF_Adapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    // count = 속도 저하 확인, 스크롤 할 때마다 Log.d()로 count 값 출력함
    int count = 0;

    public GridF_Adapter(LayoutInflater layoutInflater){
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*@Override
    public View getView(int i, View v, ViewGroup root) {
        v = layoutInflater.inflate(R.layout.item_girdf_gridv, root, false);
        ImageView imgv1 = v.findViewById(R.id.imgv1);
        ImageView imgv2 = v.findViewById(R.id.imgv2);
        Button btn_change = v.findViewById(R.id.btn_change);
        count++;
        Log.d("로그","getView: " + count);
        return v;
    }*/

    /*@Override
    public View getView(int i, View v, ViewGroup root) {
        if(v == null){
            v = layoutInflater.inflate(R.layout.item_girdf_gridv, root, false);
            v.setTag(new ViewHolder(v));
            count++;    // Tag Object 형태여서 뭐든지 담을 수 있음
        }else {
            if(v.getTag() != null){
                ViewHolder viewHolder = (ViewHolder) v.getTag();
            }
        }
        Log.d("로그","getView: " + count);

        return v;
    }*/

    @Override
    public View getView(int i, View v, ViewGroup root) {
        ViewHolder viewHolder = null;
        // ※ 중요 : 매번 인플레이션 과정을 하는 것이 아니라, 한 번 쭉 하고 저장해둔다.
        // v != null 이면, 예전에 붙였던 것을 가져와 붙인다.
        if(v == null){
            v = layoutInflater.inflate(R.layout.item_girdf_gridv, root, false);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
            count++;    // Tag Object 형태여서 뭐든지 담을 수 있음
        }else {
            if(v.getTag() != null){
                viewHolder = (ViewHolder) v.getTag();
            }
        }
        final ViewHolder tempViewHolder = viewHolder;
        viewHolder.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // index == 0 (Imageview1, Imageview2. Button )
                if(tempViewHolder.imgv1.getVisibility() == View.VISIBLE){
                    tempViewHolder.imgv1.setVisibility(View.GONE);
                    tempViewHolder.imgv2.setVisibility(View.VISIBLE);
                }else{
                    tempViewHolder.imgv2.setVisibility(View.GONE);
                    tempViewHolder.imgv1.setVisibility(View.VISIBLE);
                }
            }
        });
        Log.d("로그","getView: " + count);

        return v;
    }

    // recycler (재활용) : view(아이템 붙인거) 한 번 붙여놓고 나서 다시 계속 새로 붙이는 처리 x
    // 한 번 붙여놓은 아이템을 메모리에 저장해놓았다가 다시 사용하는 구조로 만들자 => RecyclerView 의 특징
    // ※ 위젯을 묶어놓은 DTO ==> " ViewHolder "(inner class 로 많이 사용) ※
    // RecyclerView 는 ViewHolder 라는 클래스를 강제 한다. (무조건 만들어야 함)
    public class  ViewHolder{
        // 필드 : 위젯들
        ImageView imgv1, imgv2;
        Button btn_change;

        /*public ViewHolder(ImageView imgv1, ImageView imgv2, Button btn_change) {
            this.imgv1 = imgv1;
            this.imgv2 = imgv2;
            this.btn_change = btn_change;
        }*/

        public ViewHolder(View v) {
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change = v.findViewById(R.id.btn_change);
        }
    }
}
