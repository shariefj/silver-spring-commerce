package com.silver.commerce.services;

import com.silver.commerce.dao.InventoryDao;

public class InventoryServiceImpl implements InventoryService {
	

	InventoryDao inventoryServiceImpl;

	@Override
	public int getAvailablityStatus(int pSkuId) {
		int stockLevel = inventoryServiceImpl.getStockLevel(pSkuId);	

		if(stockLevel > 0) {
			return 1005;
		}
		return 1001; 
	}

}
