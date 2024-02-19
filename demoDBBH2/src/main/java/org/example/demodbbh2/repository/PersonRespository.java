package org.example.demodbbh2.repository;

import org.example.demodbbh2.entitie.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonRespository extends JpaRepository<Person, UUID> {

    List<Person> findAllByFirstNameStartingWith(String searchValue);
    Long countAllByFirstNameStartingWith(String searchValue);



}
