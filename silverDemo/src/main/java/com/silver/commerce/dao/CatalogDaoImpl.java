package com.silver.commerce.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;
import com.silver.commerce.repository.CategoryRepository;
import com.silver.commerce.repository.ProductRepository;
import com.silver.commerce.repository.SKURepository;

@Repository
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SKURepository skuRepository;
	
	
	public void createCategory(Category pCategory) {
		
		categoryRepository.save(pCategory);
	}

	@Override
	public Category fetchCategory(int pCategoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.getOne(pCategoryId);
	}

 

	@Override
	public Product fetchProduct(int productId) {
		return productRepository.getOne(productId);
	}

	@Override
	public void createCategories(List<Category> pCategories) {
		// TODO Auto-generated method stub
		categoryRepository.saveAll(pCategories);
	}
	
	public List<Category> getAllCategories(){
		
		return categoryRepository.findAll();
	}

	@Override
	public void createSku(Sku pSku) {
		// TODO Auto-generated method stub
		skuRepository.save(pSku);
	}

	@Override
	public Sku fetchSku(int pSkuid) {
		// TODO Auto-generated method stub
		return skuRepository.getOne(pSkuid);
	}

	@Override
	public void createProducts(List<Product> pProducts) {
	
		productRepository.saveAll(pProducts);
		
	}

	@Override
	public void createSkus(List<Sku> pSkus) {
		skuRepository.saveAll(pSkus);
	}

	@Override
	public void createProduct(Product pProduct) {
		
		productRepository.save(pProduct);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Sku> getAllSkus() {
		// TODO Auto-generated method stub
		return skuRepository.findAll();
	}
	
	public List<Category> fetchRootCategories() {
		
		return categoryRepository.fetchAllRootCateqory();
	}

	@Override
	public List<Category> fetchChildCategories(int pCateogryid) {
		// TODO Auto-generated method stub
		return categoryRepository.fetchChildCategories(pCateogryid);
	}

 
}
