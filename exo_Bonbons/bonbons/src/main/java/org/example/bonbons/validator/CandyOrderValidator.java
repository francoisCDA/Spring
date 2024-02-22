package org.example.bonbons.validator;

import lombok.AllArgsConstructor;
import org.example.bonbons.entity.CandyOrder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("afterCreateOrderValidator")
public class CandyOrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CandyOrder.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CandyOrder candyOrder = (CandyOrder) target;
        if (candyOrder.getId() != 0) {
            System.out.println("la commande n° " + candyOrder.getId()  + " a bien été créé");
        }


    }
}
