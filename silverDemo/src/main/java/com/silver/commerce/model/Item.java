package com.silver.commerce.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

public class Item {

	int itemid;
	int productid;
	int skuid;
	int qty;
	PriceInfo priceInfo;
	
	 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDER_ITEM")
	Order orderRef;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getSkuid() {
		return skuid;
	}

	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public PriceInfo getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	public Order getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(Order orderRef) {
		this.orderRef = orderRef;
	}

	
	
}
