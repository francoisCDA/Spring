package com.example.demo_security.repository;

import com.example.demo_security.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
