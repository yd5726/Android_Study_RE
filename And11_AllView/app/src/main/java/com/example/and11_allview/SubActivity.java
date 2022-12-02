package com.example.and11_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class SubActivity extends AppCompatActivity {
    ListView listview_sub;
    ArrayList<ListDTO> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //getLayoutInflater();
        //LayoutInflater inflater = getLayoutInflater();

        listview_sub = findViewById(R.id.listview_sub);

        for(int i=0; i<30; i++) { // ==> DB 에서 가져옴(추후)
            list.add(new ListDTO("이름"+i, "cnt"+i));
        }

        // List_Adapter 생성해보기
        List_Adapter adapter = new List_Adapter(getLayoutInflater(),list);
        listview_sub.setAdapter(adapter);

        // 복습 ★★★
        // SubActivity 에서 ListDTO 30개를 가진 ArrayList 만들기
        //ListDTO listDTO = new ListDTO("이름","1");
        //ArrayList<ListDTO> list = new ArrayList<>();

        // List_Adapter 의 아이템 갯수 == list.size()와 같게 처리해보기

        Log.d("로그", "리스트의 사이즈: "+list.size());
    }
}