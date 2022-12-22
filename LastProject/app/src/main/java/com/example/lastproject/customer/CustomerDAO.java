package com.example.lastproject.customer;

import android.util.Log;

import com.example.conn.CommonMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // 안드로이드 DAO 는 공통 모듈로 이미 만들어뒀음 (CommonMethod)
    // 공통으로 사용될 메소드들을 따로 추가하거나 사용할 수 있게만 만들면된다.
    // 비동기
    /*
    public List<CustomerVO> selectList(){
        List<CustomerVO> list = null;
                new CommonMethod().sendPost("select.cu", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {
                Log.d("로그", "result: " + data);
                list = new Gson().fromJson(data, new TypeToken<ArrayList<CustomerVO>>(){}.getType());
            }
        });
        return list;
    }
    */
}
