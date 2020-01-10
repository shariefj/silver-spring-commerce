package com.silver.commerce.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;

@Service

public class CatalogServicesImpl implements CatalogServices{
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogServicesImpl.class);
	
	@Autowired
	CatalogDao catalogDaoImpl;

	public List<Category> fetchRootCategories() {
		return catalogDaoImpl.fetchRootCategories();
	}

	public List<Category> fetchChildCategories(int pCategoryId) {
		List<Category> childCategories =  catalogDaoImpl.fetchChildCategories(pCategoryId);
		return childCategories;
	}

	@Override
	public List<Product> fetchAllProducts() {
		return catalogDaoImpl.getAllProducts();
	}

	@Override
	public List<Sku> fetchAllSkus() {
		return catalogDaoImpl.getAllSkus();
	}

	@Override
	@Cacheable(value = "silverCache")
	public Product fetchProductById(int productId) {
		return catalogDaoImpl.fetchProduct(productId);
		
	}
	

	public Sku fetchDefaultSku(int productId) {
		return catalogDaoImpl.getDefaultSku(productId);
	}

	@Override
	public List<String> fetchAllSkuColors(int productId) {
		return catalogDaoImpl.fetchAvailableColors(productId);
	}
 }
