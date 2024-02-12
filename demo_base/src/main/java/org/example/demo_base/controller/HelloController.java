package org.example.demo_base.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String sayHello() {
        System.out.println("coucou");
        return "hello";
    }

    @RequestMapping(value = "coucou")
    @ResponseBody
    public List<String> getPersons(){
        return List.of("John Doe", "Tata Dupont", "Robert Lee", "Mister Bean" );
    }

    @RequestMapping( value = "toto")
    public String showToto() {
        return "toto";
    }


}
