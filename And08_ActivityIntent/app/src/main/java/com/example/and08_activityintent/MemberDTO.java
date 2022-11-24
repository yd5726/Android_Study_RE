package com.example.and08_activityintent;

import java.io.Serializable;

// 직렬화(Serializable) : 통신에서 전송을 편하게 하기위해 메모리 번지수를 직렬로 바꾸는 것
// 스트림(데이터 흐름)을 직렬로 정렬 시킨다.
// Main => Intent => OS => Intent => Sub
// ※ Intent 를 통해서 DTO 객체를 전송할 때는 반드시 직렬화를 해야한다.  ★★★ ※
public class MemberDTO implements Serializable {
    private String sVal1, sVal2, sVal3;

    public MemberDTO(String sVal1, String sVal2, String sVal3) {
        this.sVal1 = sVal1;
        this.sVal2 = sVal2;
        this.sVal3 = sVal3;
    }

    public String getsVal1() {
        return sVal1;
    }

    public String getsVal2() {
        return sVal2;
    }

    public String getsVal3() {
        return sVal3;
    }

    public void setsVal1(String sVal1) {
        this.sVal1 = sVal1;
    }

    public void setsVal2(String sVal2) {
        this.sVal2 = sVal2;
    }

    public void setsVal3(String sVal3) {
        this.sVal3 = sVal3;
    }
}
