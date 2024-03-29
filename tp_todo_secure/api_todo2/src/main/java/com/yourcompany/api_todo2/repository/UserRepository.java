package com.yourcompany.api_todo2.repository;


import com.yourcompany.api_todo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByPseudo(String pseudo) ;

}
