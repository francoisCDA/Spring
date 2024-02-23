package com.yourcompany.recette.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RecipeDTO {

    private long id;

    @NotEmpty
    @NotBlank
    @Size(min = 3)
    @Size(max = 30)
    private String name;

    @NotEmpty
    @NotBlank
    @Size(max = 500)
    private String ingredients;

    @NotEmpty
    @NotBlank
    @Size(max = 1500)
    private String instructions;



}
