package org.example.demo_base.controller;

import org.example.demo_base.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerSet {

    //injection de dépendance

    private final GreetingsService greetingsService;

    @Autowired
    public HelloControllerSet(@Qualifier("en") GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping(value = "hello-set")
    public String sayHello(){
        System.out.println(greetingsService.sayHello());

        return "home";
    }

}
