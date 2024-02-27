package org.example.exo_chat.entity;

import org.springframework.data.annotation.Id;

public class Message {

    @Id
    private Long id;

    private String author;

    private String message;

    public Message() {
    }

    public Message(Long id, String author, String message) {
        this.id = id;
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "(" + id + ")" + author +  " > " + message ;
    }


}
