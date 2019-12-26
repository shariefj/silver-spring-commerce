package com.silver.commerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int invnetoryId;
	
	int skuid;
	
	int stocklevel=0;
	
	int backorderlevel=0;
	
	int preorderlevel=0;
	
	int threshold=5;
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public int getInvnetoryId() {
		return invnetoryId;
	}

	public void setInvnetoryId(int invnetoryId) {
		this.invnetoryId = invnetoryId;
	}

	public int getSkuid() {
		return skuid;
	}

	public void setSkuid(int skuid) {
		this.skuid = skuid;
	}

	public int getStocklevel() {
		return stocklevel;
	}

	public void setStocklevel(int stocklevel) {
		this.stocklevel = stocklevel;
	}

	public int getBackorderlevel() {
		return backorderlevel;
	}

	public void setBackorderlevel(int backorderlevel) {
		this.backorderlevel = backorderlevel;
	}

	public int getPreorderlevel() {
		return preorderlevel;
	}

	public void setPreorderlevel(int preorderlevel) {
		this.preorderlevel = preorderlevel;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	
	
}
