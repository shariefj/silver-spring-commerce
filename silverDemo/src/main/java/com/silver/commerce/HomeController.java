package com.silver.commerce;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.model.Category;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;

 

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CatalogDao catalogDaoImpl;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		Sku greenShawl = new Sku();
		greenShawl.setActive(true);
		greenShawl.setOnSale(true);
		greenShawl.setSkuDescription("Green Shawll");
		greenShawl.setSalePrice(100.00);
		greenShawl.setListPrice(110.00);
		
		
		Product shawl = new Product();
		shawl.setProductName("Silk Shawl");
		shawl.setActive(true);
		shawl.setDescription("Michael Kors Silk Shawl");
		Set<Sku> childSkus = new HashSet<Sku>();
		childSkus.add(greenShawl);
		
		
		
		Category womenClothing = new Category();
		womenClothing.setActive(true);
		womenClothing.setCategoryDescription("Women Clothing");
		catalogDaoImpl .createCategory(womenClothing);
		
//		Set<Product> childProducts = new HashSet<Product>();
//		childProducts.add(shawl);
//		womenClothing.setChildProducts(childProducts);
		
		Category women = new Category();
		women.setActive(true);
		women.setCategoryDescription("Women Category");
		List<Category> childCategories = new ArrayList<Category>();
		childCategories.add(womenClothing);
		women.setChildCategories(childCategories);
		
		catalogDaoImpl .createCategory(women);
		
		return "home";
	}
	
}
