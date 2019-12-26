package com.silver.commerce.feeds;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;
@Component
public class CSVFeedPRocessor {
	
	@Autowired
	CatalogDao catalogDaoImpl;
	
	public static void main(String[] args) throws IOException, CsvValidationException {
		new CSVFeedPRocessor().LoadCatalogData("C:\\Users\\jalal\\git\\silver-spring-commerce\\silverDemo\\src\\main\\resources\\data\\data.csv");
	}
	
	public void LoadCatalogData(String fileName) throws IOException, CsvValidationException {
		
		 CSVReader csvReader = new CSVReader(new FileReader(fileName));
		 csvReader.readNext();
		 String[] record = null;
		 Product product = null;
		 Sku sku = null;

			while ((record = csvReader.readNext()) != null) {
				
				sku = catalogDaoImpl.fetchSku(new Integer(record[1]));
				if(sku != null) {
					sku = new Sku();
					sku.setActive(true);
					sku.setOnSale(new Boolean(record[6]).booleanValue());
					sku.setSkuName(record[5]);
					sku.setSkuName(record[4]);
					//sku.set
						
				}
				
				product = catalogDaoImpl.fetchProduct(new Integer(record[0]));
				if (product != null) {
					 product = new Product();
					 product.setDescription(record[5]);
					 product.setProductName(record[1]);
					 
					 
				}
				
				
			}
			
		}
	    		 
	
}
