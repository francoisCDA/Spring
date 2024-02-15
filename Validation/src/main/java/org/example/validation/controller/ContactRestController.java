package org.example.validation.controller;

import jakarta.validation.Valid;
import org.example.validation.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRestController {

    @GetMapping
    public Contact get(){
        return Contact.builder().age(15).lastName("nom").firstName("prenom").build();
    }

    @PostMapping
    public ResponseEntity<String> postContact(@RequestBody @Valid Contact contact, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(error -> errors.append(error.toString() + " \n "));
            return new ResponseEntity<>(errors.toString(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Contact ok", HttpStatus.CREATED);
    }




}
