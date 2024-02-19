package org.example.demodbbh2.controller;

import org.example.demodbbh2.entitie.Person;
import org.example.demodbbh2.model.PersonDTO;
import org.example.demodbbh2.service.PersonService;
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
    public List<PersonDTO> getAll(){
        return personService.listAll();
    }

    @PostMapping("/add")
    public PersonDTO add(@RequestBody PersonDTO personDTO) {
        return personService.add(personDTO);
    }




}
