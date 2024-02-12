package org.example.demo_base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/home")
public class HelloRestController {


    @RequestMapping(method = RequestMethod.GET)
    //@GetMapping
    public String sayHello(){
        System.out.println("helloooo console");
        return "hello world !!!!!!";
    }

    @GetMapping(value="test")
    public List<String> SayCoucouJson(){
        return List.of("John Doe", "Tata Dupont", "Robert Lee", "Mister Bean" );
    }

}
