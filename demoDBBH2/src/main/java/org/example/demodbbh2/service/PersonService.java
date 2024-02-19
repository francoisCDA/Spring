package org.example.demodbbh2.service;


import org.example.demodbbh2.entitie.Person;
import org.example.demodbbh2.mapper.PersonMapper;
import org.example.demodbbh2.model.PersonDTO;
import org.example.demodbbh2.repository.PersonRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRespository personRespository;
    private final PersonMapper personMapper;

    public PersonService(PersonRespository personRespository, PersonMapper personMapper) {
        this.personRespository = personRespository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> listAll(){

        return personRespository.findAll().stream().map(personMapper::personToPersonDTO).toList();
    }

    public PersonDTO add(PersonDTO personDTO){
        return personMapper.personToPersonDTO(personRespository.save(personMapper.personDtoToPerson(personDTO)));
    }

}
