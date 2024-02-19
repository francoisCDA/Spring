package org.example.validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.validation.validation.MyValid;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @NotNull(message = "on a dis pas null!!")
    @NotBlank(message = "ne peut être vide")
    @MyValid
    private String firstName;

    @NotNull
    @Size(min=3, message = "3 caractère minimum")
    private String lastName;

    @Min(3)
    @Max(42)
    private Integer age;


}
