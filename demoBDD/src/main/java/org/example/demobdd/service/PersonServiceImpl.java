package org.example.demobdd.service;

import org.example.demobdd.dao.PersonRepository;
import org.example.demobdd.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findByIdIs(id);
    }

    @Override
    public Person finByIdOpt(Long id) {
        Optional<Person> personOpt = personRepository.findById(id);
        return personOpt.orElse(null);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public boolean delete(Long id) {
        Person persoToRemove = findById(id);
        if (persoToRemove == null) {
            return false;
        }
       personRepository.delete(persoToRemove);
        return true;
    }

    @Override
    public Person update(Person person) {
        save(person);
        return person;
    }
}
