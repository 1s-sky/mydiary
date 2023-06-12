package com.diary.mydiary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Diary {
    @JsonIgnore
    int did;
    @JsonIgnore
    String uid;
    @NotEmpty
    String title;
    String text;
    @JsonIgnore
    int xpos;
    @JsonIgnore
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