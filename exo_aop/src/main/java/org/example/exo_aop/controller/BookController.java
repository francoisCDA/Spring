package org.example.exo_aop.controller;

import org.example.exo_aop.entity.Book;
import org.example.exo_aop.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/api")
public class BookController {

    private final LibraryService libraryService;

    @Autowired
    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/search")
    public List<Book> searchBook(@RequestParam(defaultValue = "all") String search ){
        if (search.equals("all")) return libraryService.getall();
        return libraryService.searchBookBySearch(search);
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable int id) {
        return libraryService.borrowBook(id);
    }

    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable int id) {
        return libraryService.unBorrowBook(id);
    }





}
