package com.silver.commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;

public interface SKURepository extends JpaRepository<Sku, Integer> {

//  Option 1 One to many
//	@Query("SELECT  s FROM Sku s JOIN s.product WHERE s.defaultSku =:default and s.product= :product")
//	public Sku findDefaultSku(@Param("default") boolean isDefault , @Param("product") Product product );

	//   Otption2	
	@Query("SELECT  s FROM Sku s WHERE s.defaultSku =:default and s.product= :product")
	public Sku findDefaultSku(@Param("default") boolean isDefault , @Param("product") Product product );
	
	
	@Query("SELECT  s.color FROM Sku s WHERE s.product= :product")
	public List<String> fetchAvailableColors( @Param("product") Product product );
	
	
	
}
