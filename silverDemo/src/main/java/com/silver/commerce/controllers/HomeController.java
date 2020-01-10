package com.silver.commerce.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.silver.commerce.OrderHolder;
import com.silver.commerce.config.SolrConfig;
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
	
	@Autowired
	OrderHolder orderHolder;
	
	@Autowired
	SolrConfig solrConfig;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping(value = "/")
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		List<Category> rootCategories = catalogServicesImpl.fetchRootCategories();
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("rootCategories", rootCategories );
		model.addAttribute("sessionCount",orderHolder.getCurrentOrder());
		return "home";
	}

	
	
}
