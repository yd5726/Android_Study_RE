package com.example.project01_clone.chat_exam;

public class ChatExamDTO {
    private int imgRes;
    private String chat_name, chat_msg, chat_date;

    public ChatExamDTO(int imgRes, String chat_name, String chat_msg, String chat_date) {
        this.imgRes = imgRes;
        this.chat_name = chat_name;
        this.chat_msg = chat_msg;
        this.chat_date = chat_date;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_msg() {
        return chat_msg;
    }

    public void setChat_msg(String chat_msg) {
        this.chat_msg = chat_msg;
    }

    public String getChat_date() {
        return chat_date;
    }

    public void setChat_date(String chat_date) {
        this.chat_date = chat_date;
    }
}
