package org.example.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;

public class MyValidConstraintValidator implements ConstraintValidator<MyValid,String> {

    private String charContain;



    @Override
    public void initialize(MyValid constraintAnnotation) {
        charContain = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (s != null) {
            result = s.contains(charContain);
        } else {
            result = false;
        }
        return result;
    }
}
