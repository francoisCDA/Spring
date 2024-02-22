package org.example.demo_aop.controller;

import org.example.demo_aop.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("home")
public class HomeController {


    private final DemoService demoService;


    public HomeController(DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping("/")
    public String get(){
       // demoService.method();
       /// demoService.methodeBool();
        demoService.methodWithAnnotation();
        return "ok";
    }

}
