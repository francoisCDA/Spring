package org.example.exo_aop.service;

import org.example.exo_aop.annotation.LoggingAnnotation;
import org.example.exo_aop.annotation.PerformanceAnnotation;
import org.example.exo_aop.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList;

    public BookService(){
        bookList = new ArrayList<>();
        bookList.add(new Book("1984", "Georges Horwell",1948));
        bookList.add(new Book("Le meilleur des mondes","Aldous Huxley",1950));
        bookList.add(new Book("H2G2","Douglas Adams",1978));
        bookList.add(new Book("L'étranger", "Albert Camus",1950));
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public List<Book> searchBookBySearch(String search){
        return bookList.stream().filter(book -> (book.getName().toLowerCase().contains(search) || book.getAuthor().toLowerCase().contains(search)) && !book.isBorrowed()).toList();
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public Book getBookById(int id) {
        return bookList.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public String borrowBook(Book book) {
        book.setBorrowed(true);
        return book.toString() + " a été emprunté";
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public String unBorrowBook(Book book) {
        book.setBorrowed(false);
        return book.toString() + " a été rendu";
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public List<Book> getall(){
        return bookList;
    }


}
