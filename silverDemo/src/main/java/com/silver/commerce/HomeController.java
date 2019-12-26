package com.silver.commerce;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.map.HashedMap;
import org.apache.solr.common.util.Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.silver.commerce.model.Category;
import com.silver.commerce.services.CatalogServices;

 

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	CatalogServices catalogServicesImpl;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		List<Category> rootCategories = catalogServicesImpl.fetchRootCategories();
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("rootCategories", rootCategories );
		
		return "home";
	}
	
	@GetMapping(value = "/categories")
	public String categoryPage(@RequestParam("categoryId") int categoryId ,Model model) {
		
		List<Category> categories = catalogServicesImpl.fetchChildCategories(categoryId);
		model.addAttribute("categories",categories);
		model.addAttribute("categoryId",categoryId);
		return "categories";
	}
}
