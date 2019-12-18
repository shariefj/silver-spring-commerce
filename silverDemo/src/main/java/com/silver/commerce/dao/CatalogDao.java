package com.silver.commerce.dao;

import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;

public interface CatalogDao {

	public void createCategory(Category pCategory);
	
	public Category fetchCategory(int pCategoryId);
	
	public void createCategory(Product pProduct);
	
	public Product fetchProduct(int productId);
	
}
