package com.silver.commerce.dao;

import java.util.List;

import com.silver.commerce.model.Inventory;

public interface InventoryDao {
	
	public int getStockLevel(int skuid);
	
	public int getBackorderLevel(int skuid);

	public int getPreOrderLevel(int skuid);
	
	public void createInventories(List<Inventory> pInventoryItems);
	
}
