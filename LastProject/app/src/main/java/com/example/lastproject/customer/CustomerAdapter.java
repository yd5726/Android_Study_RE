package com.example.lastproject.customer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conn.CommonMethod;
import com.example.lastproject.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder>{
    LayoutInflater inflater;
    ArrayList<CustomerVO> list;
    CustomerActivity activity;  // Activity 는 Intent 로만 띄운다. 이미 있는 경우는 받아와서 사용

    public void checkDelete(int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("고객 정보 삭제").setMessage("정말 삭제하시겠습니까?")
                .setIcon(R.drawable.ic_launcher_foreground);
        builder.setPositiveButton("네", (dialog, which) -> {
                new CommonMethod()
                        .setParams("id" , id)
                        .sendPost("delete.cu", (isResult, data) -> {
                            Log.d("로그", "onBindViewHolder: " + data);
                            activity.selectList();
                        });
        });
        builder.setNegativeButton("아니오", (dialog, which) -> {

        });
        builder.create().show();
    }

    public CustomerAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, CustomerActivity activity) {
        this.inflater = inflater;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_recv_customer,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.tv_id.setText(holder.tv_id.getText()+" : " + list.get(position).getId());
        //holder.tv_name.setText(holder.tv_name.getText()+" : " + list.get(position).getName());
        holder.tv_id.setText("이름" + " : " + list.get(position).getId());
        holder.tv_name.setText("정보" + " : " + list.get(position).getName());
        holder.btn3.setOnClickListener(v -> {
            checkDelete(list.get(position).getId());
        });
        /*
        holder.btn3.setOnClickListener(v -> {
            new CommonMethod()
                    .setParams("id" , list.get(position).getId())
                    .sendPost("delete.cu", (isResult, data) -> {
                        Log.d("로그", "onBindViewHolder: " + data);
                        activity.selectList();
                    });
        });
        */
        holder.btn1.setOnClickListener(v -> {
            Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.dialog_detail_cus);

            DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
            int device_width = metrics.widthPixels;
            int device_height = metrics.heightPixels * 50/100; //50%

            dialog.getWindow().setLayout(device_width,device_height);

            TextView tv_id = dialog.findViewById(R.id.tv_id);
            TextView tv_name = dialog.findViewById(R.id.tv_name);
            TextView tv_gender = dialog.findViewById(R.id.tv_gender);
            TextView tv_email = dialog.findViewById(R.id.tv_email);
            TextView tv_phone = dialog.findViewById(R.id.tv_phone);

            tv_id.setText("아이디 : " + list.get(position).getId());
            tv_name.setText("이름 : " + list.get(position).getName());
            tv_email.setText("이메일 : " + list.get(position).getEmail());
            tv_gender.setText("성별 : " + list.get(position).getGender());
            tv_phone.setText("전화번호 : " + list.get(position).getPhone());

            dialog.show(); // dialog.dismiss();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_name;
        Button btn1, btn2, btn3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            btn1 = itemView.findViewById(R.id.btn1);
            btn2 = itemView.findViewById(R.id.btn2);
            btn3 = itemView.findViewById(R.id.btn3);
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
