package com.example.demo_r2dbc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Adress {


    @Id
    private Long id;
    private String fullAddress;

    private int personId;

    @Transient
    private Person person;

}
