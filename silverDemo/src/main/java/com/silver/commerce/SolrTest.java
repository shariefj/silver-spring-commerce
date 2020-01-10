package com.silver.commerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentBase;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import org.noggit.JSONUtil;

import com.fasterxml.jackson.core.sym.Name;

public class SolrTest {
	
	static String solrurl  = "http://localhost:8983/solr/silver_core";
	static SolrClient solrClient = new HttpSolrClient.Builder(solrurl).build();
	
	public static void main(String[] args) throws SolrServerException, IOException {
		 
		      new SolrTest().deleteIndex();

		
	
	}
	
	
 public void addDocument() throws SolrServerException, IOException {
	 	
	   Map<String, String> productMap = new HashedMap();
	   productMap.put("Hello", "Hello_1");
	   productMap.put("Hello", "Hello_2");
	 
		SolrInputDocument prod1 = new SolrInputDocument();
		prod1.addField("id", "1");
		prod1.addField("description", "Solr adds block join support");
		prod1.addField("type","product");
		prod1.addField("categoryId", "cat123");
		prod1.addField("wint", productMap);
		
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
	
 
 public void addDocumentTest() throws SolrServerException, IOException {
	 
	 Collection<SolrInputDocument> batch = new ArrayList<SolrInputDocument>();
	 
	 Map<String, String> productMap = new HashedMap();
	   productMap.put("Hello", "Hello_1");
	   productMap.put("Hello", "Hello_2");

	    // Parent Doc 1, a person mamed John Jones
	    SolrInputDocument person1 = new SolrInputDocument();
	    person1.addField( "id",            "john_jones" );
	    person1.addField( "content_type",  "person"     );
	    // "_t" suffix tells Solr that it's text
	    person1.addField( "first_name_t",  "John"       );
	    person1.addField( "last_name_t",   "Jones"      );
	    // states and history used in edismax examples
	    person1.addField( "states_t",      "California Nevada Idaho Maine" );
	    person1.addField( "history_t",     "safe accident accident accident accident accident" );
	    person1.addField("wint", productMap);
	    

	    // child docs, the vehicles he owns
	    SolrInputDocument p1_car1 = new SolrInputDocument();
	    p1_car1.addField( "id",            "jj_car1"    );
	    p1_car1.addField( "content_type",  "car"        );
	    // For cars "make" is an alias for "manufacturer"
	    p1_car1.addField( "make_t",        "Honda"      );
	    p1_car1.addField( "model_t",       "Accord"     );

	    SolrInputDocument p1_car2 = new SolrInputDocument();
	    p1_car2.addField( "id",            "jj_car2"    );
	    p1_car2.addField( "content_type",  "car"        );
	    p1_car2.addField( "make_t",        "Nissan"     );
	    p1_car2.addField( "model_t",       "Maxima"     );

	    SolrInputDocument p1_bike1 = new SolrInputDocument();
	    p1_bike1.addField( "id",           "jj_bike1"   );
	    p1_bike1.addField( "content_type", "bike"       );
	    p1_bike1.addField( "make_t",       "Yamaha"     );
	    p1_bike1.addField( "model_t",      "Passion"    );

	    SolrInputDocument p1_bike2 = new SolrInputDocument();
	    p1_bike2.addField( "id",           "jj_bike2"   );
	    p1_bike2.addField( "content_type", "bike"       );
	    p1_bike2.addField( "make_t",       "Peugeot"    );
	    p1_bike2.addField( "model_t",      "Vivacity"   );

	    // Add children to parent
	    person1.addChildDocument( p1_car1  );
	    person1.addChildDocument( p1_car2  );
	    person1.addChildDocument( p1_bike1 );
	    person1.addChildDocument( p1_bike2 );

	    // Add parent to batch
	    batch.add( person1 );


	    // Parent Doc 2, person mamed Satish Smith
	    SolrInputDocument person2 = new SolrInputDocument();
	    person2.addField( "id",           "satish_smith" );
	    person2.addField( "content_type", "person"       );
	    person2.addField( "first_name_t", "Satish"       );
	    person2.addField( "last_name_t",  "Smith"        );
	    person2.addField( "states_t",     "California Texas California Maine Vermont Connecticut" );
	    person2.addField( "history_t",    "safe safe safe safe safe safe safe safe accident" );

	    // Vehicles (child docs)
	    SolrInputDocument p2_car1 = new SolrInputDocument();
	    p2_car1.addField( "id",            "ss_car1"     );
	    p2_car1.addField( "content_type",  "car"         );
	    p2_car1.addField( "make_t",        "Peugeot"     );
	    p2_car1.addField( "model_t",       "iOn"         );
	    SolrInputDocument p2_bike1 = new SolrInputDocument();
	    p2_bike1.addField( "id",           "ss_bike1"    );
	    p2_bike1.addField( "content_type", "bike"        );
	    p2_bike1.addField( "make_t",       "Honda"       );
	    p2_bike1.addField( "model_t",      "Spree"       );
	    // link objects and add to batch
	    person2.addChildDocument( p2_car1  );
	    person2.addChildDocument( p2_bike1 );
	    batch.add( person2 );

	    System.out.println( "Adding batch of " + batch.size() + " parent docs" );

	    // Submit as a group
	    solrClient.add( batch );
	    solrClient.commit();
	 
 }
 
 
 public void deleteIndex() throws SolrServerException, IOException {
	    //  Deleting the documents from Solr 
	 	solrClient.deleteByQuery("*");        
//        
//     //Saving the document 
     solrClient.commit(); 
     System.out.println("Documents deleted");
	
 }

 public void query() throws SolrServerException, IOException {
	 SolrQuery categoryQuery = new SolrQuery("categoryIds:1005");
	  
		categoryQuery.add("wt","json");
		categoryQuery.addFacetField("categoryNames");
		categoryQuery.addFacetField("brand");
		categoryQuery.setFacetMinCount(1);
	//	categoryQuery.setFields(fields)
		//categoryQuery.set
		QueryResponse response = solrClient.query(categoryQuery);
		 SolrDocumentList queryResponse = response.getResults();
	 System.out.println(queryResponse);
		for (SolrDocument solrDocument : queryResponse) {
			System.out.println(solrDocument.getFieldValue("productName"));
		}
		
//	      
	   //   new SolrTest().addDocumentTest();;
 }
 
}
