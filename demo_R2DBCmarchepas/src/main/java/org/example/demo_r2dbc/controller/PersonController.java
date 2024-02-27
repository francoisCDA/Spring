package org.example.demo_r2dbc.controller;

import org.example.demo_r2dbc.dao.PersonDAO;
import org.example.demo_r2dbc.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @PostMapping
    public void post(@RequestBody Person person){
        personDAO.add(person.getFirstname(), person.getLastname());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> get(){
        return personDAO.getAll();
    }

}
