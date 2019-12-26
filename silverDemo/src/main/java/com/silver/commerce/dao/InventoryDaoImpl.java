package com.silver.commerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.silver.commerce.model.Inventory;
import com.silver.commerce.repository.InventoryRepository;

@Repository
public class InventoryDaoImpl implements InventoryDao {

	@Autowired	
	InventoryRepository  inventoryRepository;
	
	@Override
	public int getStockLevel(int skuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBackorderLevel(int skuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreOrderLevel(int skuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createInventories(List<Inventory> pInventoryItems) {
		// TODO Auto-generated method stub
		inventoryRepository.saveAll(pInventoryItems);
	}
	
	

}
