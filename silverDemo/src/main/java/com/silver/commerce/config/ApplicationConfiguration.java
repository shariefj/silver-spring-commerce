package com.silver.commerce.config;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@Configuration
@EnableSwagger2
public class ApplicationConfiguration {
	
	@Bean(name = "mapper")
	public PropertiesFactoryBean mapper() {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("config/applicationConfig.properties"));
	    return bean;
	}
	
//	   @Bean
//	    public Docket api(){
//	        return new Docket(DocumentationType.SWAGGER_2)
//	            .select()
//	            .apis(RequestHandlerSelectors.any())
//	            .paths(PathSelectors.regex("/commerce/catalog/.*"))
//	            .build()
//	            .apiInfo(apiInfo());
//	    }
//
//	    private ApiInfo apiInfo() {
//	        return new ApiInfoBuilder().title("TITLE")
//            .description("DESCRIPTION")
//            .version("VERSION")
//            .termsOfServiceUrl("http://terms-of-services.url")
//            .license("LICENSE")
//            .licenseUrl("http://url-to-license.com")
//            .build();
//	    }

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
}
