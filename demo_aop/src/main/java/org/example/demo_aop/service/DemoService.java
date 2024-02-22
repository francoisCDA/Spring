package org.example.demo_aop.service;

import org.example.demo_aop.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public void method() {
        System.out.println("Methode demoService");
        methodeBool();

    }

    public boolean methodeBool() {
        System.out.println("Methode boolean");
        return true;
    }


    @CustomAnnotation
    public void methodWithAnnotation() {
        System.out.println("Method with annotation custom");
    }


}
