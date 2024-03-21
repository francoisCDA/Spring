package com.example.api_todo.repository;

import com.example.api_todo.model.Role;
import com.example.api_todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {


    public Optional<Role> findByRole(String role);


}
