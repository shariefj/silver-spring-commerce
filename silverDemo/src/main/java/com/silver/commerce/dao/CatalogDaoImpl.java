package com.silver.commerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

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
		return categoryRepository.getOne(pCategoryId);
	}

	


	@Override
	public Product fetchProduct(int productId) {
		Optional<Product> optional =  productRepository.findById(productId);
		Product p = null;
		if(optional.isPresent()) {
			p = optional.get();
		}

		return p;
	}

	@Override
	public void createCategories(List<Category> pCategories) {
		categoryRepository.saveAll(pCategories);
	}

	public List<Category> getAllCategories(){

		return categoryRepository.findAll();
	}

	@Override
	public void createSku(Sku pSku) {
		skuRepository.save(pSku);
	}

	@Override
	public Sku fetchSku(int pSkuid) {
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
		return productRepository.findAll();
	}

	@Override
	public List<Sku> getAllSkus() {
		return skuRepository.findAll();
	}
	
	@Cacheable(value="silverCache")
	public List<Category> fetchRootCategories() {

		return categoryRepository.fetchAllRootCateqory();
	}


	public List<Category> fetchChildCategories(int pCateogryid) {
		return categoryRepository.fetchChildCategories(pCateogryid);
	}

	@Override
	public Sku getDefaultSku(int productId) {
		 
		Product product =  fetchProduct(productId);
		return skuRepository.findDefaultSku(true,product);
	}

	@Override
	public List<String> fetchAvailableColors(int productId) {
		Product product =  fetchProduct(productId);
		return skuRepository.fetchAvailableColors(product);
	}


}
