package com.example.demo_r2dbc.repository;

import com.example.demo_r2dbc.entity.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long> {

     Flux<Person> searchAllByFirstnameContainingIgnoreCase(String firtname);

     @Query("SELECT id, firstname, lastname from person where firstname like :search")
     Flux<Person> customSearch(String search);

}
