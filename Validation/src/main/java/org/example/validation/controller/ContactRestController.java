package org.example.validation.controller;

import jakarta.validation.Valid;
import org.example.validation.exception.CustomException;
import org.example.validation.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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



    //////////////////  DEMO Exception


    @GetMapping("/hello")
    public String hello(){
        Integer error = 25/0;  /// sera géré par le RestControllerAdvice
        return "hello";
    }

    @GetMapping("/byebye")
    public String bybye(){
        if (true){
            throw new CustomException();
        }
        return "Bye bye world";
    }


    // il est possible d'Overrider la gestion de l'exception localement si l'on souhaite être plus précis que le @RestControllerAdvice et rediriger vers une page en particulier
    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleArithmeticExceptionSurPlace(ArithmeticException ex, Model model) {

        model.addAttribute("errorMessage",ex.getMessage());
        return "pageDeGestionDExcetionPersonnalise";
    }


}
