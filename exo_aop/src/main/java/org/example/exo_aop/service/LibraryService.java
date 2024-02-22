package org.example.exo_aop.service;

import org.example.exo_aop.annotation.LoggingAnnotation;
import org.example.exo_aop.annotation.PerformanceAnnotation;
import org.example.exo_aop.entity.Author;
import org.example.exo_aop.entity.Book;
import org.example.exo_aop.repository.AuthorRepository;
import org.example.exo_aop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;


    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public List<Book> searchBookBySearch(String search){
        return bookRepository.findAllByNameContains(search);
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public Book getBookById(int id) {

        Optional<Book> book =  bookRepository.findById(id);
        return book.orElse(null);
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public String borrowBook(Integer id) {

        Book book = getBookById(id);

        if (book != null) {
            if (book.isBorrowed()) return "le livre n'est pas disponible";
            book.setBorrowed(true);
            return book.toString() + " a été emprunté";
        }
        throw new RuntimeException("livre inexistant");
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public String unBorrowBook(Integer id) {

        Book book = getBookById(id);

        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
            return book.toString() + " a été rendu";
        }
        throw new RuntimeException("fail");
    }

    @LoggingAnnotation
    @PerformanceAnnotation
    public List<Book> getall() {
        return (List<Book>) bookRepository.findAll();
    }


    public Author createAuthor(String lastName, String firstName){
        Author author = new Author();
        author.setLastName(lastName);
        author.setFirstName(firstName);

        return authorRepository.save(author);

    }

    public Author getAuthorById(Long id) {
        Optional<Author> author = authorRepository.findById(id);

        return author.orElse(null);
    }


}
