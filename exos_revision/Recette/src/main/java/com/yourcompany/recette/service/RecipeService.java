package com.yourcompany.recette.service;

import com.yourcompany.recette.dto.RecipeDTO;
import com.yourcompany.recette.entity.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RecipeService {

    private final List<Recipe> recipes;


    public RecipeService() {
        this.recipes = new ArrayList<>();
    }


    public int countRecipes() {
        return recipes.size();
    }


    public void newRecipe(RecipeDTO recipeDto) {

        Recipe newRecipe = new Recipe();
        newRecipe.setName(recipeDto.getName());
        newRecipe.setInstruction(recipeDto.getInstructions());
        newRecipe.setIngredients(Arrays.stream(recipeDto.getIngredients().split(";")).toList());

        recipes.add(newRecipe);
    }

    public List<RecipeDTO> searchByString(String search) {
        List<RecipeDTO> retour = new ArrayList<>();
        for (Recipe re :recipes) {
            RecipeDTO recipeDTO = re.toDTO();
            if (recipeDTO.getName().toLowerCase().contains(search.toLowerCase()) || recipeDTO.getIngredients().toLowerCase().contains(search.toLowerCase()) ){
                retour.add(recipeDTO);
            }
        }
        return retour;
    }

    public RecipeDTO getRecipeById(long id) {
        Recipe retour =  recipes.stream().filter(recipe -> recipe.getId() == id ).findFirst().orElse(null);

        if (retour != null) {
            return retour.toDTO();
        }
        throw new RuntimeException("Invalid Id");
    }

}
