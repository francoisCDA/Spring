package com.m2i.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commentary {

    private UUID id;

    private UUID postId;

    @Size(max = 20)
    private String auteur;

    @Email
    private String email;

    @NotBlank
    @NotEmpty
    private String message;

    private Date date;



}
