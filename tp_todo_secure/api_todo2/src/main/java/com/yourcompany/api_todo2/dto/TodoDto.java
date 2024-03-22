package com.yourcompany.api_todo2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private Long id;

    private String title;

    private String description;

    private Boolean isCompleted;

}
