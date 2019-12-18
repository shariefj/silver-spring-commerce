package com.silver.commerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.repository.CategoryRepository;

@Service
 
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public void createCategory(Category pCategory) {
		
		categoryRepository.save(pCategory);
	}

	@Override
	public Category fetchCategory(int pCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCategory(Product pProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product fetchProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
