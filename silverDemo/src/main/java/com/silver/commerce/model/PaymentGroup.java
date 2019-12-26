package com.silver.commerce.model;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

public class PaymentGroup {
	
	String paymentMethod;
	
	Address billingAddress;

	@OneToOne
	@PrimaryKeyJoinColumn
	Order orderRef;

	public PaymentGroup() {
		// TODO Auto-generated constructor stub
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Order getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(Order orderRef) {
		this.orderRef = orderRef;
	}
	
	
}
