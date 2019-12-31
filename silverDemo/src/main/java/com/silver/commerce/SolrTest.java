package com.silver.commerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrTest {
	
	static String solrurl  = "http://localhost:8983/solr/silver_core";
	static SolrClient solrClient = new HttpSolrClient.Builder(solrurl).build();
	
	public static void main(String[] args) throws SolrServerException, IOException {
		 
		SolrQuery query = new SolrQuery();
		
		query.setQuery("*:*");
		query.setFields("description","categoryId","id");
		SolrDocumentList response = solrClient.query(query).getResults();
		
		System.out.println("response" + response);
		
		for (SolrDocument solrDocument : response) {
			
			System.out.println(solrDocument.getFieldValue("type"));
			
		}
		
	     // query.setQuery("*:*");  
		
		//new SolrTest().addDocument();
		
	}
	
	
 public void addDocument() throws SolrServerException, IOException {
	 
		SolrInputDocument prod1 = new SolrInputDocument();
		prod1.addField("id", "1");
		prod1.addField("description", "Solr adds block join support");
		prod1.addField("type","product");
		prod1.addField("categoryId", "cat123");
		
		SolrInputDocument skuDocument = new SolrInputDocument();
		skuDocument.addField("id", "1");
		skuDocument.addField("description", "fabulous of westminister");
		skuDocument.addField("type","sku");
		skuDocument.addField("price","100");
		
		SolrInputDocument skuDocument1 = new SolrInputDocument();
		skuDocument1.addField("id", "2");
		skuDocument1.addField("description", "apricot is automnoumouse");
		skuDocument1.addField("type","sku");
		skuDocument1.addField("price","120");
		
		SolrInputDocument skuDocument2 = new SolrInputDocument();
		skuDocument2.addField("id", "3");
		skuDocument2.addField("description", "afronamo vilmantoro instruction");
		skuDocument2.addField("type","sku");
		skuDocument2.addField("price","105");
		
		
		SolrInputDocument prod2 = new SolrInputDocument();
		prod2.addField("id", "2");
		prod2.addField("description", "jacket");
		prod2.addField("type","product");
		prod2.addField("categoryId", "cat123");
		
		SolrInputDocument sku4 = new SolrInputDocument();
		sku4.addField("id", "5");
		sku4.addField("description", "red color jacket");
		sku4.addField("type","sku");
		sku4.addField("price","115");
		
		SolrInputDocument sku6 = new SolrInputDocument();
		sku6.addField("id", "6");
		sku6.addField("description", "Green color jacket");
		sku6.addField("type","sku");
		sku6.addField("price","125");
		
		SolrInputDocument sku7 = new SolrInputDocument();
		sku7.addField("id", "7");
		sku7.addField("description", "Blue Color Jacket");
		sku7.addField("type","sku");
		sku7.addField("price","112");
		
		
		SolrInputDocument prod3 = new SolrInputDocument();
		prod3.addField("id", "3");
		prod3.addField("description", "Bag");
		prod3.addField("type","product");
		prod3.addField("categoryId", "cat143");
		
		SolrInputDocument sku8 = new SolrInputDocument();
		sku8.addField("id", "4");
		sku8.addField("description", "Black Leather Bag");
		sku8.addField("type","sku");
		sku8.addField("price","115");
		
		SolrInputDocument sku9 = new SolrInputDocument();
		sku9.addField("id", "8");
		sku9.addField("description", "Gold leather Bag");
		sku9.addField("type","sku");
		sku9.addField("price","125");
		
		SolrInputDocument sku10 = new SolrInputDocument();
		sku10.addField("id", "9");
		sku10.addField("description", "younger Bag ");
		sku10.addField("type","sku");
		sku10.addField("price","112");
		
		
		List<SolrInputDocument> childSkus1 = new ArrayList<SolrInputDocument>();
		
		childSkus1.add(skuDocument);
		childSkus1.add(skuDocument1);
		childSkus1.add(skuDocument2);
		
		
		List<SolrInputDocument> childSkus2 = new ArrayList<SolrInputDocument>();
		childSkus2.add(sku10);
		childSkus2.add(sku9);
		childSkus2.add(sku7);
		
		List<SolrInputDocument> childSkus3 = new ArrayList<SolrInputDocument>();
		childSkus2.add(sku4);
		childSkus2.add(sku8);
		childSkus2.add(sku6);
		
		
		prod1.addChildDocuments(childSkus1);
		prod2.addChildDocuments(childSkus2);
		prod3.addChildDocuments(childSkus3);
		
		List<SolrInputDocument> products = new ArrayList<SolrInputDocument>();
		products.add(prod1);
		products.add(prod2);
		products.add(prod3);
		
		solrClient.add(products);
		solrClient.commit();
		
	    System.out.println("Documents added"); 
 }
	

}
