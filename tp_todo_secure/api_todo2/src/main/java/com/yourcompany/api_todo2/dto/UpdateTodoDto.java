package com.yourcompany.api_todo2.dto;

import lombok.Data;

@Data
public class UpdateTodoDto {

    private Long id;

    private String title;

    private String description;

    private Boolean isCompleted;

}
