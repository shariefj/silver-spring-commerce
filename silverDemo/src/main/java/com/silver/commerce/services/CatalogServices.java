package com.silver.commerce.services;

import java.util.List;

import com.silver.commerce.model.Category;

public interface CatalogServices {

	public List<Category> fetchRootCategories();
	
	public List<Category> fetchChildCategories(int pCategoryId);
}
