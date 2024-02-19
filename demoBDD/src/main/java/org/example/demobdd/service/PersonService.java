package org.example.demobdd.service;

import org.example.demobdd.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findById(Long id);

    void save(Person person);

    boolean delete(Long id);

    Person update(Person person);

}
