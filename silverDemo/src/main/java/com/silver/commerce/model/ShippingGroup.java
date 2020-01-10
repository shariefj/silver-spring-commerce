package com.silver.commerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "SHIPPING")
public class ShippingGroup  {
	@SequenceGenerator(name="shp", initialValue=7001, allocationSize=50)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ,generator = "shp")
	int shippingGroupid;
	
	String handlingInstructions;
	
	@OneToOne(cascade = CascadeType.ALL)
	PriceInfo priceInfo;
	
	String shippingMethod;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address shippingAddress;
	
	String state;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonBackReference
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Order getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(Order orderRef) {
		this.orderRef = orderRef;
	}
	
	
}
