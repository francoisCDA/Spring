package com.example.demo_r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String firstname;
    private String lastname;

}
