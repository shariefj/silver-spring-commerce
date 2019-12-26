package com.silver.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.silver.commerce.model.Category;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query("SELECT cat FROM Category cat WHERE cat.root = 1")
	public List<Category> fetchAllRootCateqory();
	
	@Query("SELECT distinct p FROM Category p JOIN FETCH p.childCategories WHERE p.categoryId = (:categoryId)")
	public List<Category> fetchChildCategories(@Param("categoryId") Integer categoryId );
}
 