package com.silver.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.silver.commerce.model.Sku;

public interface SKURepository extends JpaRepository<Sku, Integer> {

}
