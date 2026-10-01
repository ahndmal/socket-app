package com.anma.skt.models;

import java.time.LocalDateTime;

public class Message {

    private String body;
    private String time;
    private String author;

    public Message(String body, String time, String author) {
        this.body = body;
        this.time = time;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
