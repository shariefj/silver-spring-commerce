package com.silver.commerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {
	@SequenceGenerator(name="citem", initialValue=6001, allocationSize=50)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "citem")
	int itemid;
	int productid;
	int skuid;
	int qty;
	
	@OneToOne(cascade = CascadeType.ALL)
	PriceInfo priceInfo;
	
	String state;
	
	 
	@ManyToOne(cascade = CascadeType.ALL,optional = false)
	@JoinColumn(name="orderId")
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}
