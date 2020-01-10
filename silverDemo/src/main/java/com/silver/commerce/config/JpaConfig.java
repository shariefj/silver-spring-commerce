package com.silver.commerce.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
 
@Configuration
@EnableJpaRepositories(basePackages = {"com.silver.commerce"})
@EnableTransactionManagement
public class JpaConfig {
	  @Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.silver.commerce" });
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	      return em;
	   }
      
	  
	  @Bean
	  public DataSource dataSource(){
		  HikariConfig hikariConfig = new HikariConfig();
		  hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/commerce?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true");
		  hikariConfig.setUsername("silver_commerce");
		  hikariConfig.setPassword("silver_commerce");
		  hikariConfig.addDataSourceProperty("cachePrepStmts" ,"true");
		  hikariConfig.addDataSourceProperty("prepStmtCacheSize" ,"250");
		  hikariConfig.addDataSourceProperty( "prepStmtCacheSqlLimit","2048");
		  hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  hikariConfig.setConnectionTimeout(30000);
		  hikariConfig.setIdleTimeout(60000);
		  hikariConfig.setMaxLifetime(1800000);
		  hikariConfig.setPoolName("SilverCommercePool");
		  hikariConfig.setMaximumPoolSize(2);
		  hikariConfig.setMinimumIdle(1);
		  
		  HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	      return dataSource;
	  }
	  
	  
	  @Bean
	  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	      return transactionManager;
	  }
	   
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	  }
	   
	  Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "create");
	      properties.setProperty("hibernate.show_sql", "true");
	      properties.setProperty("hibernate.format_sql", "true");
	      // properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
	      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	      return properties;
	  }
}