package org.example.exo_aop.repository;

import org.example.exo_aop.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {

    List<Book> findAllByNameContains(String search);

}
