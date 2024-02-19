package org.example.demobdd.controller;

import lombok.AllArgsConstructor;
import org.example.demobdd.entity.Person;
import org.example.demobdd.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonRestController {

    private PersonService personService;

    @GetMapping("/list")
    public List<Person> getAllPerson(){
        return personService.findAll();
    }

    @PostMapping("/add")
    public Person addOnPerson(@RequestBody Person person){
        personService.save(person);
        return person;
    }

    @GetMapping("/person/{id}")
    public Person getOnePerson(@PathVariable Long id) {
        return personService.findById(id);
    }

    @DeleteMapping("/person/{id}")
    public Person delete(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PutMapping("/person")
    public Person put(@RequestBody Person person) {
        return personService.update(person);
    }


}
