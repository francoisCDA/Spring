package com.example.demo.controller;


import com.example.demo.entities.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;


    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<PersonDTO> getAllPersons(){
        return personService.listPersons();
    }

    @PostMapping("/add")
    public PersonDTO addPerson(@RequestBody PersonDTO dto){
        return personService.addPerson(dto);
    }


}
