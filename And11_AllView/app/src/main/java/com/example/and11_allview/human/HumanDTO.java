package com.example.and11_allview.human;

public class HumanDTO {
    private String human_title, human_txt, human_price;
    private int poster;

    public HumanDTO(String human_title, String human_txt, String human_price, int poster) {
        this.human_title = human_title;
        this.human_txt = human_txt;
        this.human_price = human_price;
        this.poster = poster;
    }

    public String getHuman_title() {
        return human_title;
    }

    public void setHuman_title(String human_title) {
        this.human_title = human_title;
    }

    public String getHuman_txt() {
        return human_txt;
    }

    public void setHuman_txt(String human_txt) {
        this.human_txt = human_txt;
    }

    public String getHuman_price() {
        return human_price;
    }

    public void setHuman_price(String human_price) {
        this.human_price = human_price;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
