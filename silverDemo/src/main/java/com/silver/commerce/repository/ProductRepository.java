package com.silver.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silver.commerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {


	
}
