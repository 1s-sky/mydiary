package com.diary.mydiary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Diary {
    int did;
    String uid;
    @NotEmpty(message = " * 제목을 작성해주세요.")
    String title;
    @Size(min=5, message=" * {min}글자이상을 기록해주세요.")
    String text;
    int xpos;
    int ypos;

    public Diary(){}
    public Diary(String title, String text){
        this.title = title;
        this.text = text;
        this.xpos = 50;
        this.ypos = 50;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
}