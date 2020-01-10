package com.silver.commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silver.commerce.OrderHolder;
import com.silver.commerce.OrderResponse;
import com.silver.commerce.helper.OrderManager;
import com.silver.commerce.model.Item;
import com.silver.commerce.model.Order;

@Controller
public class CartModifierController {

	
	@Autowired
	OrderManager orderManager;
	
	@Autowired
	OrderHolder orderHolder; 
	
	@PostMapping(value = "/addItem",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public OrderResponse addItemToOrder(@ModelAttribute("item")Item item,Model model) {
	
		Item pItem = orderManager.createCommerceItem(item.getProductid(), item.getSkuid(), item.getQty());
		Order order = orderHolder.getCurrentOrder();
		orderManager.addItemToOrder(pItem, order);
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setItemCount(order.getItems().size());
		model.addAttribute("order", order);
		return 	orderResponse;
	}
	 
	
	
 
}
