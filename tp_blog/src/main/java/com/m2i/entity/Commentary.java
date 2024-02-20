package com.m2i.entity;

import com.m2i.dto.CommentaryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commentary {

    @Id
    private UUID id;

    private UUID postId;

    private String auteur;

    private String email;

    private String message;

    private Date date;


    public CommentaryDTO toCommentaryDto() {
        return CommentaryDTO.builder()
                .id(this.id)
                .postId(this.postId)
                .auteur(this.auteur)
                .email(this.email)
                .message(this.message)
                .date(this.date)
                .build();
    }
}
