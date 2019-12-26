package com.silver.commerce;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.silver.commerce.dao.CatalogDao;
import com.silver.commerce.dao.InventoryDao;
import com.silver.commerce.dao.InventoryDaoImpl;
import com.silver.commerce.model.Category;
import com.silver.commerce.model.Inventory;
import com.silver.commerce.model.Product;
import com.silver.commerce.model.Sku;
import com.silver.commerce.repository.InventoryRepository;
import com.silver.commerce.services.CatalogServices;

 

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CatalogDao catalogDaoImpl;
	
	@Autowired
	CatalogServices catalogServicesImpl;
	
	@Autowired
	InventoryDao inventoryDaoImpl;
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
	
	@PostConstruct
	public void init() {
	
	List<Category> categories = new ArrayList<Category>(); 
	

	// Shoe Category
	Category shoes = new Category();
	shoes.setActive(true);
	shoes.setCategoryDescription("Shoe Categories");
	shoes.setCategoryName("Shoes");
	shoes.setRoot(true);

	Category boots = new Category();
	boots.setActive(true);
	boots.setCategoryDescription("Boots For all ");
	boots.setCategoryName("Boots");
	boots.setParent(shoes);
	
	Category sneakers = new Category();
	sneakers.setActive(true);
	sneakers.setCategoryDescription("Sneakers for all ");
	sneakers.setCategoryName("Sneakers");
	sneakers.setParent(shoes);
	
	
	List<Category> shoesCategory = new ArrayList<Category>();
	shoesCategory.add(boots);
	shoesCategory.add(sneakers);
	shoes.setChildCategories(shoesCategory);

	

	// Watches Category
	Category watches = new Category();
	watches.setActive(true);
	watches.setCategoryDescription("Watches Category");
	watches.setCategoryName("Watches");
	watches.setRoot(true);

	Category mensWatch = new Category();
	mensWatch.setActive(true);
	mensWatch.setCategoryDescription("Men's Watch");
	mensWatch.setCategoryName("Men");
	mensWatch.setParent(watches);
	
	Category womensWatch = new Category();
	womensWatch.setActive(true);
	womensWatch.setCategoryDescription("Womens Watch");
	womensWatch.setCategoryName("Women");
	womensWatch.setParent(watches);
	
	
	List<Category> watchesCategory = new ArrayList<Category>();
	watchesCategory.add(mensWatch);
	watchesCategory.add(womensWatch);
	watches.setChildCategories(watchesCategory);
	
	
	
	// Men Clothing Category 
	
	Category men = new Category();
	men.setActive(true);
	men.setCategoryDescription("Men Category");
	men.setCategoryName("Men");
	men.setRoot(true);
	
	Category menClothing = new Category();
	menClothing.setActive(true);
	menClothing.setCategoryDescription("Men Clothing");
	menClothing.setCategoryName("Clothing");
	menClothing.setParent(men);

	Category menTees = new Category();
	menTees.setActive(true);
	menTees.setCategoryDescription("Men Tees");
	menTees.setCategoryName("Tees");
	menTees.setParent(menClothing);
	
	Category menTops = new Category();
	menTops.setActive(true);
	menTops.setCategoryDescription("Men Tops");
	menTops.setCategoryName("Tops");
	menTops.setParent(menClothing);
	
	
	List<Category> menCloth = new ArrayList<Category>();
	menCloth.add(menTees);
	menCloth.add(menTops);
	menClothing.setChildCategories(menCloth);

	
		Category women = new Category();

		
		Category womenClothing = new Category();
		womenClothing.setActive(true);
		womenClothing.setCategoryDescription("Women Clothing");
		womenClothing.setCategoryName("Clothing");
		womenClothing.setParent(women);
	
		Category womenTees = new Category();
		womenTees.setActive(true);
		womenTees.setCategoryDescription("Women Tees");
		womenTees.setCategoryName("Tees");
		womenTees.setParent(womenClothing);
		
		Category womenTops = new Category();
		womenTops.setActive(true);
		womenTops.setCategoryDescription("Women Tops");
		womenTops.setCategoryName("Tops");
		womenTops.setParent(womenClothing);
		
		
		List<Category> wClothingChildcat = new ArrayList<Category>();
		wClothingChildcat.add(womenTees);
		wClothingChildcat.add(womenTops);
		womenClothing.setChildCategories(wClothingChildcat);
		
		
		
		List<Category> menChild = new ArrayList<Category>();
		
		menChild.add(menClothing);
		
		
		
		women.setActive(true);
		women.setRoot(true);
		women.setCategoryDescription("Women Category");
		women.setCategoryName("Women");
		List<Category> childCategories = new ArrayList<Category>();
		
		childCategories.add(womenClothing);
		
		women.setChildCategories(childCategories);
		
		categories.add(men);
		categories.add(shoes);
		categories.add(sneakers);
		categories.add(boots);
		categories.add(watches);
		categories.add(mensWatch);
		categories.add(womensWatch);
		categories.add(menClothing);
		categories.add(menTees);
		categories.add(menTops);
		categories.add(womenClothing);
		categories.add(womenTees);
		categories.add(womenTops);
		categories.add(women);
		
		catalogDaoImpl.createCategories(categories);
		
		Sku greenShawl = new Sku();
		greenShawl.setActive(true);
		greenShawl.setOnSale(true);
		greenShawl.setSkuDescription("Green Shawll");
		greenShawl.setSkuName("A Green Color Shawl with Palatte");
		greenShawl.setSalePrice(100.00);
		greenShawl.setListPrice(110.00);
		
		Sku yellowShawl = new Sku();
		yellowShawl.setActive(true);
		yellowShawl.setOnSale(true);
		yellowShawl.setSkuDescription("Green Shawll");
		yellowShawl.setSkuName("A Yello Color Shawl with Palatte");
		yellowShawl.setSalePrice(130.00);
		yellowShawl.setListPrice(140.00);
		
		
		Sku maroonShirt = new Sku();
		maroonShirt.setActive(true);
		maroonShirt.setOnSale(true);
		maroonShirt.setSkuDescription("Slim fit Mens Shirt Maroon blended with linen ,nylon & Cotton");
		maroonShirt.setSkuName("A Maroon Color slim fit shirt");
		maroonShirt.setSalePrice(132.00);
		maroonShirt.setListPrice(150.00);
		
		Sku greyShirt = new Sku();
		greyShirt.setActive(true);
		greyShirt.setOnSale(false);
		greyShirt.setSkuDescription("Slim fit Mens Shirt Grey blended with linen ,nylon & Cotton");
		greyShirt.setSkuName("A Grey Color slim fit shirt");
		greyShirt.setSalePrice(150.00);
		greyShirt.setListPrice(150.00);
		
		
		Sku whiteBoots = new Sku();
		whiteBoots.setActive(true);
		whiteBoots.setOnSale(false);
		whiteBoots.setSkuDescription("White Boos for the fantastic snow ");
		whiteBoots.setSkuName("White Boots");
		whiteBoots.setSalePrice(110.00);
		whiteBoots.setListPrice(110.00);
		
		Sku silverBoots = new Sku();
		silverBoots.setActive(true);
		silverBoots.setOnSale(true );
		silverBoots.setSkuDescription("Silvery  Boots for the fantastic snow ");
		silverBoots.setSkuName("Sivler Boots");
		silverBoots.setSalePrice(120.00);
		silverBoots.setListPrice(150.00);
		
		
		Sku whiteSneakers = new Sku();
		whiteSneakers.setActive(true);
		whiteSneakers.setOnSale(false);
		whiteSneakers.setSkuDescription("White Sneakers for the fantastic spring ");
		whiteSneakers.setSkuName("White Sneakers");
		whiteSneakers.setSalePrice(110.00);
		whiteSneakers.setListPrice(110.00);
		
		Sku silverSneakers = new Sku();
		silverSneakers.setActive(true);
		silverSneakers.setOnSale(true );
		silverSneakers.setSkuDescription("Silvery Sneakers for the fantastic spring  ");
		silverSneakers.setSkuName("Sivler Sneakers");
		silverSneakers.setSalePrice(120.00);
		silverSneakers.setListPrice(150.00);
		
		Sku versa2 = new Sku();
		versa2.setActive(true);
		versa2.setOnSale(false);
		versa2.setSkuDescription("White Fitbeat for the fantastic gymming ");
		versa2.setSkuName("White Fitbit");
		versa2.setSalePrice(180.00);
		versa2.setListPrice(180.00);
		
		
		Sku versa2lite = new Sku();
		versa2lite.setActive(true);
		versa2lite.setOnSale(true);
		versa2lite.setSkuDescription("White Fitbeat for the fantastic gymming ");
		versa2lite.setSkuName("Silver Fitbit");
		versa2lite.setSalePrice(124.00);
		versa2lite.setListPrice(180.00);
		
		
		//watches
		
		Product fitbitversa = new Product();
		fitbitversa.setProductName("Fitbit Versa2men");
		fitbitversa.setActive(true);
		fitbitversa.setDescription("Fitbit versa for men");
		Set<Sku> versas = new HashSet<Sku>();
	//	versas.add(versa2);
		versas.add(versa2lite);
		//versa2.setProduct(fitbitversa);
		versa2lite.setProduct(fitbitversa);
		fitbitversa.setChildSkus(versas);
		fitbitversa.setParentCategory(mensWatch);
		
		Product fitbitversaw = new Product();
		fitbitversaw.setProductName("Fitbit Versa2");
		fitbitversaw.setActive(true);
		fitbitversaw.setDescription("Fitbit versa for women");
		Set<Sku> versasw = new HashSet<Sku>();
		versasw.add(versa2);
	//	versasw.add(versa2lite);
		versa2.setProduct(fitbitversaw);
		//versa2lite.setProduct(fitbitversaw);
		fitbitversaw.setChildSkus(versasw);
		fitbitversaw.setParentCategory(womensWatch);
		

		//Sneakers
		Product sureSneakers = new Product();
		sureSneakers.setProductName("Sure Sneakers for Spring");
		sureSneakers.setActive(true);
		sureSneakers.setDescription("Sure Sneakers");
		Set<Sku> sneaks = new HashSet<Sku>();
		sneaks.add(whiteBoots);
		sneaks.add(silverBoots);
		whiteBoots.setProduct(sureSneakers);
		silverBoots.setProduct(sureSneakers);
		sureSneakers.setChildSkus(sneaks);
		sureSneakers.setParentCategory(sneakers);
		
		
		//Boots
		
		Product kidsSnowBoots = new Product();
		kidsSnowBoots.setProductName("Kids Snow Boots");
		kidsSnowBoots.setActive(true);
		kidsSnowBoots.setDescription("Kids Snow Boots for super snows");
		Set<Sku> bootsKsus = new HashSet<Sku>();
		bootsKsus.add(whiteBoots);
		bootsKsus.add(silverBoots);
		whiteBoots.setProduct(kidsSnowBoots);
		silverBoots.setProduct(kidsSnowBoots);
		kidsSnowBoots.setChildSkus(bootsKsus);
		kidsSnowBoots.setParentCategory(boots   );

		
		
		Product shawl = new Product();
		shawl.setProductName("Silk Shawl");
		shawl.setActive(true);
		shawl.setDescription("Michael Kors Silk Shawl");
		Set<Sku> childSkus = new HashSet<Sku>();
		childSkus.add(greenShawl);
		childSkus.add(yellowShawl);
		greenShawl.setProduct(shawl);
		yellowShawl.setProduct(shawl);
		shawl.setChildSkus(childSkus);
		shawl.setParentCategory(womenTees);
		
		
			
		Product shirt = new Product();
		shirt.setProductName("Mens Shirt with beatuififul Linen culture");
		shirt.setActive(true);
		shirt.setDescription("Mens Shirt with beatuififul Linen culture");
		Set<Sku> shirtSkus = new HashSet<Sku>();
		shirtSkus.add(maroonShirt);
		shirtSkus.add(greyShirt);
		maroonShirt.setProduct(shirt);
		greyShirt.setProduct(shirt);
		shirt.setChildSkus(shirtSkus);
		shirt.setParentCategory(menTops);
		
		
		List<Product> pProducts = new ArrayList<Product>();
		pProducts.add(shawl);
		pProducts.add(shirt);
		pProducts.add(kidsSnowBoots);
		pProducts.add(sureSneakers);
		pProducts.add(fitbitversa);
		pProducts.add(fitbitversaw);
		
		catalogDaoImpl.createProducts(pProducts);
		
		Inventory inventory = null;
		List<Inventory> inventories = new ArrayList<Inventory>();
		
		for(int i=1 ; i <=10 ;i++) {
			inventory  = new Inventory();
			inventory.setSkuid(i);
			inventory.setStocklevel(100);
			inventories.add(inventory);
		}
		
		inventoryDaoImpl.createInventories(inventories);	
	}
}
