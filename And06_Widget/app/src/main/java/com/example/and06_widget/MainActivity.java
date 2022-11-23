package com.example.and06_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //TextView tv_text = tv_text.findViewById(R.id.tv_text);;
    //Button btn_text = btn_text.findViewById(R.id.btn_text);
    // ↑ 오류코드 : onCreate() 호출 이전에 id 값을 전달해서??
    // 렌더링 (Web), DOM : 음.
    // A. 수명주기(Life Cycle) : onCreate
    // setContentView <= 디자인 파일과 연결되는 구간.

    TextView tv_text;
    Button btn_text, btn_login;
    RadioButton radio_btn1, radio_btn2;
    RadioGroup rdo_grp;
    EditText edt_id, edt_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = findViewById(R.id.tv_text);       // ★
        btn_text = findViewById(R.id.btn_text);
        radio_btn1 = findViewById(R.id.radio_btn1);
        radio_btn2 = findViewById(R.id.radio_btn2);
        rdo_grp = findViewById(R.id.rdo_grp);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);

        // 모든 위젯이 null이 아닌 상태일 때 => Event를 줄 수 있다.
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tv_text.setText("버튼이 클릭!");
                btn_text.setText("???");

            }
        });

        // Q. tv_text 클릭 시 버튼의 글씨가 바뀌게 처리해보기
        // Object > View > ... // ★
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_text.setText("버튼은");
            }
        });

        tv_text.setOnClickListener(this); // ★this : @Override public void onClick(View v)
        btn_text.setOnClickListener(this);

        radio_btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // isChecked : is... <= boolean
                // Q. isChecked
                // 체크가 되었다면 rdo_2의 체크 상태를 해제하고 싶다.
                //radio_btn1.setChecked(isChecked);
                //radio_btn2.setChecked(false);
                if(isChecked){
                    radio_btn2.setChecked(false);
                }
            }
        });

        radio_btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    radio_btn1.setChecked(false);
                }
            }
        });

        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Q. 디버깅 모드를 활용해서 문제를 해결 해보기
                // 어떤 라디오 버튼이 선택 되었는지 알 수 있도록 값을 로그에 찍어보기
                //Log.d("로그", "msg: " + checkedId);
                Log.d("로그", "msg: " + group.getCheckedRadioButtonId());
                RadioButton temp_rdo = (RadioButton) group.getChildAt(checkedId-1);
                Log.d("로그", "onCheckedChanged:"+temp_rdo.getText());
                if(checkedId == 1){
                    Log.d("로그", "onCheckedChanged: 아주 나쁨!!!");
                }

            }
        });

        // edt_id에 현재 입력된 값을 가져오는 메소드는 edt_id.getText()
        // Q1. btn_login이 클릭되면 edit_id의 값이 admin이고 edt_pw의 값이 1234일 때 로그인이되게 처리해보기
        //    그 외에는 "아이디 또는 비밀번호를 확인해주세요." 출력
        // Q2. ※ 패스워드에는 반드시 숫자값만 입력이되게 만들어보기. 숫자 외에 값은 전부 오류로 본다.
        // Q3. ※ 사용자 : edt_pw 에 어떤값이든 입력을 할 예정
        //       메소드를 이용해서 해당하는 edt_pw 위젯에 있는값이 숫자이면 로그인을 진행하고
        //       그게아니라면 숫자만 입력해주세요 라는 메세지가 콘솔에 출력되게 처리
        // edt_pw에 입력 된 값이 숫자인지를 판단해서 해당하는 숫자를 리턴하는 메소드!
        // --------------------------------------------------------------------------------------------------
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rtn_str();
                method();
                //Log.d("로그인 확인", "onClick: "+ edt_id.getText());
                if(edt_id.getText().toString().equals("admin") && edt_pw.getText().toString().equals("1234")){
                    Log.d("로그인 확인", "로그인 완료");
                }else{
                    Log.d("로그인 확인", "아이디 또는 비밀번호를 확인해주세요.");
                }
                /*if(edt_id.getText().toString().equals("admin")){
                    String value = edt_pw.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    if(finalValue == 1234){
                        Log.d("로그인 확인", "로그인 완료");
                    }else{
                        Log.d("로그인 확인", "비밀번호는 숫자값만을 입력");
                    }
                }else{
                    Log.d("로그인 확인", "아이디 또는 비밀번호를 확인해주세요.");
                }*/
            }
        });
    }//onCreate
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_text){
            btn_text.setText("텍스트 뷰 클릭 됨");
        }else if(v.getId() == R.id.btn_text){
            tv_text.setText("텍스트 뷰 클릭됨");
        }
    }

    // 1. edt_pw에 입력된 값이 int인지를 판단해서 해당하는 int를 리턴하는 메소드
    //    단, 입력 값이 숫자가 아닌 경우에는 -1을 return 한다.
    // 2. 파라메터로 EditText를 입력받아 입력받은 EditText가 ↑ 경우인지를 판단하는 메소드
    //    int 타입을 리턴한다.

    int method(){
        //edt_pw.getText()<== 여기에 있는값이 숫자인지 아닌지 어떻게 알수가있을까???????
        // Wrapper Class <= 를 이용해서 해당하는 타입으로 바꿀수있는지의 여부
        // 숫자형태로 바꿔보기.
        //테스트 케이스 1: 숫자만 입력하고 로그인 버튼 눌러보기 ex)1234
        //테스트 케이스 2: 숫자와 문자를 혼합해서 입력하고 로그인 버튼 눌러보기 ex)1234a
        //테스트 케이스에서 오류가 발생하는 부분을 오류가 안나게 메소드 수정
        try {
            return Integer.parseInt(edt_pw.getText().toString());
        } catch (Exception e){
            Log.d("로그인 확인", "method: 숫자로 바꿀수 없는 값이 들어왔다.");
            return -1;
        }
        //return -1;
    }//method()

    //↑ String값이 입력되었을때 숫자가 아니라면 return String을 하는 메소드
    // 숫자라면 String error를 리턴하세요. rtn_str<=-
    String rtn_str(){
        try {
            Integer.parseInt(edt_id.getText().toString());
            return "error";
        } catch(Exception e){
            return edt_id.getText() + "";
        }
    }//rtn_str()
}