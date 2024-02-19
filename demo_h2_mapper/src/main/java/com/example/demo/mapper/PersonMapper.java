package com.example.demo.mapper;


import com.example.demo.entities.Person;
import com.example.demo.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    
    @Mapping(source = "firstName", target = "blabla")
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDto(Person person);


    @Mapping(source = "blabla", target = "firstName")
    Person personDtoToPerson(PersonDTO dto);


    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date){
        LocalDate now = LocalDate.now();

        Integer age = now.getYear() - date.getYear();

        if(now.minusYears(age).isBefore(date)){
            age--;
        }

        return age;
    }

}
