package org.example.bonbons.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class ValidatorEventregistry implements InitializingBean {

    private Map<String, Validator> validator;

    private ValidatingRepositoryEventListener validatingRepositoryEventListener;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<String> events = Arrays.asList("beforeCreate", "afterCreate", "beforeDelete", "beforeSave", "beforeLinkSave");

        for (Map.Entry<String,Validator> entry: validator.entrySet() ){
            validatingRepositoryEventListener.addValidator("beforeCreate", entry.getValue());
        }

        for (Map.Entry<String,Validator> entry: validator.entrySet() ){
            validatingRepositoryEventListener.addValidator("afterCreate", entry.getValue());
        }



    }
}
