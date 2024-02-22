package org.example.exo_aop.entity;

public class Book {

    private static int count = 0;

    private Integer id;

    private String name;

    private String author;

    private int year;

    private boolean isBorrowed;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        isBorrowed = false;
        id = ++count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "le livre : " + name + " écrit par " + author + " en " +  year + '.';
    }
}
