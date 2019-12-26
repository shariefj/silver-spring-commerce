package com.silver.commerce.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Category;

@Service
public class CatalogServicesImpl implements CatalogServices{
	
	private static final Logger logger = LoggerFactory.getLogger(CatalogServicesImpl.class);
	
	@Autowired
	CatalogDao catalogDaoImpl;

	public List<Category> fetchRootCategories() {
		// TODO Auto-generated method stub
		return catalogDaoImpl.fetchRootCategories();
	}

	public List<Category> fetchChildCategories(int pCategoryId) {
		
		
		List<Category> childCategories =  catalogDaoImpl.fetchChildCategories(pCategoryId);
		
		System.out.println("Size ::::: " + childCategories.size());
		
		return childCategories;
	}

 }
