package com.example.demo_r2dbc.repository;

import com.example.demo_r2dbc.entity.Adress;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AdressRepository extends R2dbcRepository<Adress, Long> {
    @Query("SELECT a.id, a.full_adress, p.id, p.firstname, p.lastname from adress as a inner join person as p on a.person_Id = p.id where a.id = :id")
    Mono<Adress> findAdressByIdWithPerson(long id);
}
