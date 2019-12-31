package com.silver.commerce.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CATEGORY")
@JsonIgnoreProperties(value = {"childCategories"})
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer categoryId;
	
	String categoryName;
	
	String categoryDescription;
	
	String categoryImageUrl;
	
	boolean root = false;
 
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	@JoinTable(name = "CHILD_CATEGORIES")
	private Category parent;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "parent")
	
	List<Category> childCategories = new ArrayList<Category>();
	
	boolean active = false;
	
	@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "parentCategory")
	@JsonManagedReference
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

 
	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean isRoot) {
		this.root = isRoot;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

 
 
	
}
