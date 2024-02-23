package com.yourcompany.recette.entity;

import com.yourcompany.recette.dto.RecipeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    private static int count = 0;


    private long id;

    private String name;

    private String instruction;

    private List<String> ingredients;

    public Recipe(){
        id = ++count;
    }

    public RecipeDTO toDTO() {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(id);
        recipeDTO.setName(name);
        recipeDTO.setIngredients(ingredients.toString());
        recipeDTO.setInstructions(instruction);
        return recipeDTO;
    }


}
