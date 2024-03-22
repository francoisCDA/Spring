package com.yourcompany.api_todo2.repository;


import com.yourcompany.api_todo2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {


    public Optional<Role> findByRole(String role);


}
