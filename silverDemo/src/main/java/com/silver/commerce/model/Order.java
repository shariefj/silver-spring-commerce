package com.silver.commerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SILVER_ORDER")
public class Order {
	
	enum State { 
	    INCOMPLETE, SUBMITTED, FULFILLED; 
	} 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	
	State state = State.INCOMPLETE;
	
	Date submittedDate;
	
	Date creationDate = new Date();
	
	String orderChannel;
	
	String orderCreatedBy;
	
	String profileId;
	
	@OneToOne(cascade = CascadeType.ALL)
	PriceInfo  priceInfo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "orderRef")
	List<Item> items = new ArrayList<Item>();
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "orderRef")
	@JsonManagedReference
	ShippingGroup shippingGroup;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "orderRef")
	@JsonManagedReference
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

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getOrderChannel() {
		return orderChannel;
	}

	public void setOrderChannel(String orderChannel) {
		this.orderChannel = orderChannel;
	}

	public String getOrderCreatedBy() {
		return orderCreatedBy;
	}

	public void setOrderCreatedBy(String orderCreatedBy) {
		this.orderCreatedBy = orderCreatedBy;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public PriceInfo getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}
	

}
