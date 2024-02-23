package com.yourcompany.recette.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Recipe {


    private long id;

    private String name;

    private String instruction;

    private List<String> ingredients;




}
