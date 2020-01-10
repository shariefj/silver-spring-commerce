package com.silver.commerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silver.commerce.OrderHolder;
import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Category;
import com.silver.commerce.model.Order;
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
	
	@Autowired
	OrderHolder orderHolder;
	
 	
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
	
	//PathVariable example
	@GetMapping("/details/{categoryId}")
	public List<Category> getChild(@PathVariable int categoryId ) {
		
		return catalogServicesImpl.fetchChildCategories(categoryId);
	}
	
	@GetMapping("/details/product/{productId}")
	public Product getProduct(@PathVariable int productId ) {
		
		return catalogServicesImpl.fetchProductById(productId);
	}
	
	@GetMapping("/order")
	public Order getOrder() {
		
		return orderHolder.getCurrentOrder();
	}
	
	
	@GetMapping("/details/sku/{productId}")
	public List<String> getDefaultSku(@PathVariable int productId ) {
		return catalogServicesImpl.fetchAllSkuColors(productId);
	}


	
}
