package org.example.exo_aop.controller;

import org.example.exo_aop.entity.Book;
import org.example.exo_aop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/api")
public class bookController {

    private final BookService bookService;

    @Autowired
    public bookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam(defaultValue = "all") String search ){
        if (search.equals("all")) return bookService.getall();
        return bookService.searchBookBySearch(search);
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null ) {
            if (!book.isBorrowed()) {
                return bookService.borrowBook(book);
            }
        }
        return "livre non trouvé";
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null ) {
            if (!book.isBorrowed()) {
                return bookService.unBorrowBook(book);
            }
        }
        return "livre non trouvé";
    }





}
