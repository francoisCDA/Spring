package com.yourcompany.recette.controller;

import com.yourcompany.recette.dto.RecipeDTO;
import com.yourcompany.recette.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("nbRecipes",recipeService.countRecipes());
        model.addAttribute("recipeDto",new RecipeDTO());

        return "index";
    }

    @PostMapping("/add")
    public String newRecipe(@Valid @RequestBody RecipeDTO recipeDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "index";
        }

        recipeService.newRecipe(recipeDto);

        return "redirect:/recipes";
    }

    @GetMapping("/search")
    public String searchRecipie(@RequestParam String search, Model model){

        model.addAttribute("recipies", recipeService.searchByString());

        return "recipies/recipies";

    }

    @GetMapping("/search/{id}")
    public String getRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe",recipeService.getRecipesById(id));
        return "recipes/details";
    }

}
