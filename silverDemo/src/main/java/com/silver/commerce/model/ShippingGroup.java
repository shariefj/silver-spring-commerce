package com.silver.commerce.model;

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

public class ShippingGroup  {
	
	String handlingInstructions;
	
	PriceInfo priceInfo;
	
	String shippingMethod;
	
	Address shippingAddress;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	Order orderRef;

	public ShippingGroup() {
		// TODO Auto-generated constructor stub
	}

	public String getHandlingInstructions() {
		return handlingInstructions;
	}

	public void setHandlingInstructions(String handlingInstructions) {
		this.handlingInstructions = handlingInstructions;
	}

	public PriceInfo getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
