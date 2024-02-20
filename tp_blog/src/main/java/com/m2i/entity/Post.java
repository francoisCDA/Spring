package com.m2i.entity;

import com.m2i.dto.PostDTO;
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

    private String title;

    private String description;

    private String article;

    private Date date;

    public PostDTO toPostDTO() {
        return  PostDTO.builder()
                .id(this.id)
                .title(this.title)
                .description(this.description)
                .article(this.article)
                .date(this.date)
                .build();
    }
}
