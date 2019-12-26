package com.silver.commerce.model;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productId;
	
	String productName;
	
	String description;
	
	String productImageUrl;
	
	String brand;
	
	boolean isActive = false;
	
	Date startDate;
	
	Date endDate;

	
	@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "product",cascade = CascadeType.ALL)
	
	Set<Sku> childSkus = new HashSet<Sku>();
	
	
	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name="categoryId")
	@JoinTable(name = "PRD_CHLD_CAT")
	@JsonBackReference
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
