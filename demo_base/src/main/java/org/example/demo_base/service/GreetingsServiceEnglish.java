package org.example.demo_base.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service("en")
public class GreetingsServiceEnglish implements GreetingsService {
    public String sayHello() {
        return "Hello everyone !!!";
    }

}
