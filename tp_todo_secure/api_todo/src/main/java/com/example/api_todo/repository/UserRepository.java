package com.example.api_todo.repository;

import com.example.api_todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByPseudo(String pseudo) ;

}
