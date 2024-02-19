package org.example.demobdd.dao;

import org.example.demobdd.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
