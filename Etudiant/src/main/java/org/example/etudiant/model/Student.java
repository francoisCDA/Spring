package org.example.etudiant.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private UUID id;

    @NotBlank(message = "Le nom ne peut être vide")
    @NotNull
    private String lastName;

    @NotBlank(message = "Le prénom ne peut être vide")
    @NotNull
    private String firstName;

    @NotNull(message = "saisir une date" )
    @Past(message = "la date ne peut être dans le futur")
    private LocalDate birthday;

    @Email(message = "format mail invalide")
    private String mail;


}
