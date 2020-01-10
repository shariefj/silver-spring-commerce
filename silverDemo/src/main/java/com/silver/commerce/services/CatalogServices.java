package com.silver.commerce.services;

import java.util.List;

import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;

public interface CatalogServices {

	public List<Category> fetchRootCategories();
	
	public List<Category> fetchChildCategories(int pCategoryId);
	
	public List<Product> fetchAllProducts();
	
	public List<Sku> fetchAllSkus();
	
	public Product fetchProductById(int productId);
	
	public Sku fetchDefaultSku(int productId);
	
	public List<String> fetchAllSkuColors(int productId);
}
