package com.example.and06_widget;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity {
    TextView tv_test;
    Button btn_text, btn_login;
    RadioButton radio_btn1, radio_btn2;
    RadioGroup rdo_grp;
    EditText edt_id, edt_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_text = findViewById(R.id.btn_text);
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_test.setText("테스트를 클릭하면 이 문장으로 변경");
                btn_text.setText("버튼을 클릭하면 이 문장으로 변경");
            }
        });

        radio_btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d("TAG", "onCheckedChanged: " );
                    radio_btn2.setChecked(false);
                }
            }
        });

        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
    }
}
