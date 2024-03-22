package com.yourcompany.api_todo2.model;

import com.yourcompany.api_todo2.dto.TodoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private boolean isCompleted;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TodoDto toTodoDto(){
        return TodoDto.builder()
                .id(id)
                .title(title)
                .description(description)
                .isCompleted(isCompleted)
                .build();
    }

}
