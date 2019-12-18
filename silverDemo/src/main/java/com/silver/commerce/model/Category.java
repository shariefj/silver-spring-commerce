package com.silver.commerce.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryId;
	
	String categoryName;
	
	String categoryDescription;
	
	String categoryImageUrl;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CHILD_CATEGORIES")
	List<Category> childCategories = new ArrayList<Category>();
	
	boolean active;
	
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "parentCategory")
	Set<Product> childProducts = new HashSet<Product>();
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param categoryName
	 * @param categoryDescription
	 */
	public Category(String categoryName, String categoryDescription) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	 
	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<Product> getChildProducts() {
		return childProducts;
	}


	public void setChildProducts(Set<Product> childProducts) {
		this.childProducts = childProducts;
	}

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}

	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}

	public List<Category> getChildCategories() {
		return childCategories;
	}

	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}
	
	
}
