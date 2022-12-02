package com.example.and11_allview;

import android.widget.ImageView;

public class ListFDTO {
    private String name, txt;
    int poster;

    // [Alt + Insert]
    public ListFDTO(String name, String txt, int poster) {
        this.name = name;
        this.txt = txt;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
