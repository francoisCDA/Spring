package org.example.exo_aop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    private static int count = 0;

    @Id
    private Integer id;

    private String name;


    private int year;

    private boolean isBorrowed;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;



    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        isBorrowed = false;
        id = ++count;
    }

    public Book() {

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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
