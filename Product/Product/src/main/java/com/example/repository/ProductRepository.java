package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // <--- ENSURE THIS IS PRESENT

import com.example.model.ProductModel;

@Repository // <--- ENSURE THIS IS PRESENT
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    // No custom methods needed here unless you define them
}