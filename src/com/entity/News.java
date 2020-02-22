package com.entity;

import java.util.Date;

public class News {
    private String time;
    private String type;
    private String title;
    private String content;

    public String getTime() {
        return time;
    }

    public String setTime(String time) {
        return this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
