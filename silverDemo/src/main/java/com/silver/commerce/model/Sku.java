package com.silver.commerce.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SKU")
public class Sku {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer skuId;
	String skuName;
	String skuDescription;
	String skuImageUrl;
	boolean onSale = false;
	boolean isActive = false;
	double listPrice;
	double SalePrice;
	Date startDate;
	Date endDate;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER,optional = true)
	@JoinTable(name = "PRD_CHLD_SKUS")
	@JoinColumn(name="productId")
	Product product;
	
	public Sku() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getSkuDescription() {
		return skuDescription;
	}

	public void setSkuDescription(String skuDescription) {
		this.skuDescription = skuDescription;
	}

	public String getSkuImageUrl() {
		return skuImageUrl;
	}

	public void setSkuImageUrl(String skuImageUrl) {
		this.skuImageUrl = skuImageUrl;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public double getSalePrice() {
		return SalePrice;
	}

	public void setSalePrice(double salePrice) {
		SalePrice = salePrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
