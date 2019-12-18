package com.silver.commerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productId;
	
	String productName;
	
	String description;
	
	String productImageUrl;
	
	boolean isActive;
	
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "product")
	Set<Sku> childSkus = new HashSet<Sku>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
	@JoinColumn(name="categoryId",nullable = false)
	@JoinTable(name = "PRD_CHLD_CAT")
	Category parentCategory;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String description, String productImageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.productImageUrl = productImageUrl;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Sku> getChildSkus() {
		return childSkus;
	}

	public void setChildSkus(Set<Sku> childSkus) {
		this.childSkus = childSkus;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	
}
