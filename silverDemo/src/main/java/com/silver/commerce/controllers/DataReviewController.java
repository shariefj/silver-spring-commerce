package com.silver.commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;
import com.silver.commerce.services.CatalogServices;
import com.silver.commerce.services.CatalogServicesImpl;

@RestController
@RequestMapping("/catalog")
public class DataReviewController {

	@Autowired
	CatalogDao catalogDao;
	
	@Autowired
	CatalogServices catalogServicesImpl;
	
 	
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		
		return catalogDao.getAllCategories();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return catalogDao.getAllProducts();
	}
	
	@GetMapping("/skus")
	public List<Sku> getAllSkus() {
		return catalogDao.getAllSkus();
	}
	
	@GetMapping("/rootcategories")
	public List<Category> getRootCategories() {
		
		return catalogServicesImpl.fetchRootCategories();
	}
	
	@GetMapping("/details")
	public List<Category> getChild(@RequestParam("categoryId") int categoryId ) {
		
		return catalogServicesImpl.fetchChildCategories(categoryId);
	}
	
}
