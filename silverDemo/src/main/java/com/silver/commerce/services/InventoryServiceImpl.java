package com.silver.commerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silver.commerce.dao.InventoryDao;

@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryDao inventoryDaoImpl;

	@Override
	public int getAvailablityStatus(int pSkuId) {
		int stockLevel = inventoryDaoImpl.getStockLevel(pSkuId);	

		if(stockLevel > 0) {
			return 1005;
		}
		return 1001; 
	}

}
