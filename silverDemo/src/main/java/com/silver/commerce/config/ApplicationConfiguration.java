package com.silver.commerce.config;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@Configuration
@EnableSwagger2
@EnableCaching
public class ApplicationConfiguration {

	@Autowired
	SolrConfig solrConfig;

	@Bean
	public SolrClient solrClient() {

		String solrUrl =  "http://"+solrConfig.getSolrHost()+":"+solrConfig.getCorePort()+"/solr/"+solrConfig.getCoreName();
		SolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		return solrClient;
	}

	@Bean
	public Swagger2DocumentationConfiguration swagger2Config() {
		return new Swagger2DocumentationConfiguration();
	}



	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
		.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
		.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
	
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheManager(){
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
		
	}


}
