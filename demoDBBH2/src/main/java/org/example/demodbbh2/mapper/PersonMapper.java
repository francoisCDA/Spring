package org.example.demodbbh2.mapper;

import org.example.demodbbh2.entitie.Person;
import org.example.demodbbh2.model.PersonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(source="firstName", target="blabla")
    @Mapping(source="birthday", target = "age", qualifiedByName = "convertDateToAge")
    PersonDTO personToPersonDTO(Person person);

    @Mapping(source="blabla", target="firstName")
    Person personDtoToPerson(PersonDTO personDTO);


    @Named("convertDateToAge")
    public static Integer convertDataToAge(LocalDate date){
        LocalDate hui = LocalDate.now();

        Integer age = hui.getYear() - date.getYear();

        if (hui.minusYears(age).isBefore(date)){
            age--;
        }
        return age;
    }


}
