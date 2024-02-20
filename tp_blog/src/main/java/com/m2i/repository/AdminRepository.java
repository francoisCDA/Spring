package com.m2i.repository;

import com.m2i.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Administrator,Long> {

    Long countByAdminNameAndPassword(String adminName, String password);

}
