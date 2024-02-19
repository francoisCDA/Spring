package com.m2i.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private UUID id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 20)
    @Size(max = 100)
    private String description;

    @NotNull
    @NotBlank
    @Size(min = 150)
    @Size(max = 4000)
    private String article;

    private Date date;

}
