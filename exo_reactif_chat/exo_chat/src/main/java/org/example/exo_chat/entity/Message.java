package org.example.exo_chat.entity;

public class Message {

    private String author;

    private String message;

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
        return "-" + author +  " > " + message ;
    }
}
