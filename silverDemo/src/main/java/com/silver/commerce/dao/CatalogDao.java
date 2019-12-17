package com.silver.commerce.dao;

import com.silver.commerce.model.Category;

public interface CatalogDao {

	public void createCategory(Category pCategory);
	
	public Category fetchCategory(int pCategoryId);
}
