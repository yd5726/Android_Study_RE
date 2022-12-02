package com.example.and11_allview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and11_allview.R;

//2. 밑에서 만든(ViewHolder)를 이용해서 RecyclerViewViewHolder 를 상속받는다. (BaseAdapter 아님)
public class RecvAdapter extends RecyclerView.Adapter<RecvAdapter.KmjViewHolder>{
    // ※ LayoutInflater : 어댑터가 붙일 수 있는 공간을 마련, 직접 붙이는 처리를 하기위한 객체 ※
    LayoutInflater inflater;

    // 3. 우리가 만들어 놓은 ViewHolder 를 실제로 만들고 return 해주는 부분
    // ViewHolder == 몇 개의 위젯이 들어있는지 OS가 판단 x, 우리가 커스텀해서 사용함.
    // 어떤 아이템에는 이미지 뷰가 3개, 어떤 아이템에는 텍스트 뷰가 3개로 다를 수가 있음.
    // BaseAdapter(getView 메소드) == 현) onCreateViewHolder

    public RecvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public KmjViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_girdf_gridv, parent, false);
        KmjViewHolder viewHolder = new KmjViewHolder(v);

        return viewHolder;
    }

    // 5. 데이터가 있다면 position holder 에 담아져 있는 (칸) 위젯과 연결 부분 (Binding)
    @Override
    public void onBindViewHolder(@NonNull KmjViewHolder h, int i) {
        h.btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(h.imgv1.getVisibility() == View.VISIBLE){
                    h.imgv1.setVisibility(View.GONE);
                    h.imgv2.setVisibility(View.VISIBLE);
                }else{
                    h.imgv2.setVisibility(View.GONE);
                    h.imgv1.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    // 4. 아이템의 갯수를 지정하는 부분
    @Override
    public int getItemCount() {
        return 30;
    }

    // 일반 ==> ViewHolder 타입
    // 1. ViewHolder 타입을 상속 받은 innerClass ViewHolder 를 만든다. ( 이름은 관례상 ViewHolder)
    public  class KmjViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv1, imgv2;
        Button btn_change;
        public KmjViewHolder(@NonNull View v) {
            super(v);
            // 위젯들을 찾아서 초기화하는 기능을 했음. v.find..()
            imgv1 = v.findViewById(R.id.imgv1);
            imgv2 = v.findViewById(R.id.imgv2);
            btn_change = v.findViewById(R.id.btn_change);
        }
    }

    /* position 이 꼬여서 데이터가 마음대로 통제가 안되는 경우 ★★★
    *  RecyclerView 자체의 이슈 =>  getItemId, getItemViewType 를 Override!!!
    */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
