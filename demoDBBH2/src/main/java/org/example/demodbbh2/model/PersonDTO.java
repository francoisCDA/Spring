package org.example.demodbbh2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private UUID id;
    private String blabla;
    private String lastName;
    private LocalDate birthday;
    private Integer age;



}
