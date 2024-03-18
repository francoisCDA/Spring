package com.example.demo_security.controller;

import com.example.demo_security.model.Product;
import com.example.demo_security.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAll(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @PostMapping("/post")
    public Product postProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PatchMapping("/")
    public Product patchProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productRepository.deleteById(id);
    }




}
