package com.silver.commerce.dao;

import java.util.List;

import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;

public interface CatalogDao {

	public void createCategory(Category pCategory);
	
	public List<Category> fetchChildCategories(int pCateogryid);
	
	public Category fetchCategory(int pCategoryId);
 	
	public Product fetchProduct(int productId);

	public void createSku(Sku pSku);
	
	public Sku fetchSku(int pSku);
	
	public void createCategories(List<Category> pCategories);
	
	public void createProducts(List<Product> pProducts);
	
	public void createProduct(Product pProduct);

	public void createSkus(List<Sku> pSkus);
	
	public List<Category> getAllCategories();
	
	public List<Product> getAllProducts();
	
	public List<Sku> getAllSkus();
	
	public List<Category> fetchRootCategories() ;
	
	public Sku getDefaultSku(int productId);
	
	public List<String> fetchAvailableColors  (int productId);
	
}
