package org.example.demo_base.service;

import org.springframework.stereotype.Service;

@Service("fr")
public class GreetingsServiceFrench implements GreetingsService {

    @Override
    public String sayHello() {
        return "Bonjour tout le monde !";
    }





}
