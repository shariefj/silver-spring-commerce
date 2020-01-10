package com.silver.commerce;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.silver.commerce.helper.OrderManager;
import com.silver.commerce.model.Order;
import com.silver.commerce.model.PaymentGroup;
import com.silver.commerce.model.ShippingGroup;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderHolder {

	public Order currentOrder;
	
	@Autowired
	public OrderManager mOrderHelper;
	
	
	/**
	 * 
	 */
	public OrderHolder() {
		// TODO Auto-generated constructor stub
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	
	
	public OrderManager getmOrderHelper() {
		return mOrderHelper;
	}

	public void setmOrderHelper(OrderManager mOrderHelper) {
		this.mOrderHelper = mOrderHelper;
	}

	public Order createInitialOrder() {
		
		ShippingGroup shippingGroup = null;
		PaymentGroup  paymentGroup = null;
		
		if (currentOrder == null) {
			currentOrder = new Order();	
			shippingGroup = getmOrderHelper().createShippingGroup();
			paymentGroup = getmOrderHelper().createPaymentGroup();
			currentOrder.setShippingGroup(shippingGroup);
			shippingGroup.setOrderRef(currentOrder);
			currentOrder.setPaymentGroup(paymentGroup);
			paymentGroup.setOrderRef(currentOrder);
			System.out.println(currentOrder.getOrderId() +"***********");
		}

		return currentOrder;
	}
	
	 
	
	public int getOrderNumber() {
	
		int i = 10;
		++i;
		return i; 
	
	}
	
//	This is back up of ...
	
//	if (currentSku == null) {
//		Sku count  = new Sku();
//		repository.save(count);
//		currentSku = count;
//	}
//	
//	 
//	 
//	return currentSku.getSkuId(); 
	
	
	
	
	
	
	@PostConstruct
	public void initialize() {
		
		createInitialOrder();
	}

	
}
