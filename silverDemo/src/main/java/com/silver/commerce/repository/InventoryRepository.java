package com.silver.commerce.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.silver.commerce.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
	
	@Query("SELECT inv FROM Inventory inv WHERE inv.skuid = (:skuid)")
	public Inventory findBySkuId(@Param("skuid") int skuId);

}
