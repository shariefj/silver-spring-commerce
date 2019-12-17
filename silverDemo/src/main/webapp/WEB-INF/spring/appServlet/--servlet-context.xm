<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/tx 
		http://www.springframework.org/schema/tx/spring-tx.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="com.silver.commerce" />
	
	<!--  Hibernate changes starts Here -->
 
 	<!-- This produces a container-managed EntityManagerFactory; 
         rather than application-managed EntityManagerFactory as in case of LocalEntityManagerFactoryBean-->
    <beans:bean id="entityManagerFactoryBean" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
      <beans:property name="dataSource" ref="dataSource" />
      <!-- This makes /META-INF/persistence.xml is no longer necessary -->
     <beans:property name="packagesToScan" value="com.silver.commmerce" />
      <!-- JpaVendorAdapter implementation for Hibernate EntityManager.
           Exposes Hibernate's persistence provider and EntityManager extension interface -->
   <beans:property name="jpaVendorAdapter">
        <beans:bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter" />
      </beans:property>
      <beans:property name="jpaProperties">
         <beans:props>
            <beans:prop key="hibernate.hbm2ddl.auto">create-drop</beans:prop>
            <beans:prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</beans:prop>
         </beans:props>
      </beans:property>
   </beans:bean>
	
	
	<!-- Simple implementation of the standard JDBC DataSource interface, 
        configuring the plain old JDBC DriverManager via bean properties -->
   <beans:bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
      <beans:property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
      <beans:property name="url" value="jdbc:mysql://192.168.1.249:3306/COMMERCE?useSSL=false&amp;serverTimezone=UTC" />
      <beans:property name="username" value="silver_commerce" />
      <beans:property name="password" value="silver_commerce" />
   </beans:bean>
		
	 <!-- This transaction manager is appropriate for applications that use a single JPA EntityManagerFactory for transactional data access. 
        JTA (usually through JtaTransactionManager) is necessary for accessing multiple transactional resources within the same transaction. -->
    <beans:bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
      <beans:property name="entityManagerFactory" ref="entityManagerFactoryBean" />
   </beans:bean>
    
    <!-- Step 4: Enable configuration of transactional behavior based on annotations -->
	<tx:annotation-driven transaction-manager="transactionManager" />
	
	<beans:bean id="persistenceExceptionTranslationPostProcessor" class=
  "org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor" />
  
</beans:beans>
