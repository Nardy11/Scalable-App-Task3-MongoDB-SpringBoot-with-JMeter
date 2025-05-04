package com.example.Task_3.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    private String text;
    private String date;

    public Comment(String text, String date) {
        this.text = text;
        this.date = date;
    }

    public Comment() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
