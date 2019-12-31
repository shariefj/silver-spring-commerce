package com.silver.commerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PAYMENT")
public class PaymentGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paymentId;
	
	String paymentMethod;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address billingAddress;
	
	String state;

	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonBackReference
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
