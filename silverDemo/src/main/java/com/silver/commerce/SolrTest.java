package com.silver.commerce;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
import org.apache.solr.common.params.SolrParams;

public class SolrTest {
	
	public static void main(String[] args) throws SolrServerException, IOException {
		String solrurl  = "http://192.168.1.249:8983/solr/netest";
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrurl)
	    .withConnectionTimeout(10000)
	    .withSocketTimeout(60000)
	    .build();
		//solrClient.ping();
		Map<String,SolrInputField> testMap = new HashedMap();
		SolrInputField field = new SolrInputField("newyork");
		SolrInputField name = new SolrInputField("jalal");
		testMap.put("city",field);
		testMap.put("name",name);
		SolrInputDocument docs = new SolrInputDocument(testMap);
		docs.setField("city", "Ohio");
		docs.setField("city", "Chorlette");
		docs.setField("city", "Qdoba");
		solrClient.add(docs);
		SolrParams solrParames = new SolrQuery().set("city", "Qdoba");
		
		QueryResponse  queryResponse = solrClient.query(solrParames);
		
		System.out.println(queryResponse.jsonStr());
		
		//UpdateResponse response = solrClient.commit();
		//System.out.println(response.jsonStr());
	}

}
