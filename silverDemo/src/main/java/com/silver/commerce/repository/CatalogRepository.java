package com.silver.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silver.commerce.model.Category;

@Repository
public interface CatalogRepository extends JpaRepository<Category, Integer> {

}
