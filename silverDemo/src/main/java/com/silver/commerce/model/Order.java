package com.silver.commerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Order {
	
	int orderId;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "orderRef")
	List<Item> items = new ArrayList<Item>();
	
	@OneToOne
	ShippingGroup shippingGroup;
	
	PaymentGroup paymentGroup;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ShippingGroup getShippingGroup() {
		return shippingGroup;
	}

	public void setShippingGroup(ShippingGroup shippingGroup) {
		this.shippingGroup = shippingGroup;
	}

	public PaymentGroup getPaymentGroup() {
		return paymentGroup;
	}

	public void setPaymentGroup(PaymentGroup paymentGroup) {
		this.paymentGroup = paymentGroup;
	}
	
	

}
