package com.silver.commerce.helper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.silver.commerce.model.Address;
import com.silver.commerce.model.Item;
import com.silver.commerce.model.Order;
import com.silver.commerce.model.PaymentGroup;
import com.silver.commerce.model.PriceInfo;
import com.silver.commerce.model.ShippingGroup;

@Component
public class OrderManager {
	
	public Order addItemToOrder(Item pItem,Order pOrder) {
		boolean merged = false;
		if (null != pItem && pOrder != null) {
			List<Item> items = pOrder.getItems();
			if (items != null) {
				merged = mergeItemIfExist(items,pItem);
				if (!merged) {
					items.add(pItem);
				}
			}
		}
		return pOrder;
	}

	/**
	 * 
	 * @return
	 */
	public ShippingGroup createShippingGroup() {
		ShippingGroup sGroup = new ShippingGroup();
		Address address = new Address();
		PriceInfo shippingPrice = new PriceInfo();
		sGroup.setPriceInfo(shippingPrice);
		sGroup.setShippingAddress(address);
		return sGroup; 
		
	}
	
	public PaymentGroup createPaymentGroup() {
		PaymentGroup paymentGroup =  new PaymentGroup();
		Address address = new Address();
		paymentGroup.setBillingAddress(address);
		return paymentGroup;
	}
	
	public Order addShippingGroupToOrder(Order pOrder,ShippingGroup pShippingGroup) {
		
		pOrder.setShippingGroup(pShippingGroup);
		return pOrder;
	}
	
	public Order addPaymentGroupToOrder(Order pOrder,PaymentGroup pPaymentGroup) {
		
		pOrder.setPaymentGroup(pPaymentGroup);
		return pOrder;
	}
	
	public Item createCommerceItem(int productId,int pSkuid,int quantity) {
		
		 Item commerceItem = new Item();
		 commerceItem.setProductid(productId);
		 commerceItem.setSkuid(pSkuid);
		 commerceItem.setQty(quantity);
		 
		return commerceItem;
	}
	
	
	public boolean mergeItemIfExist(List<Item> pItems, Item pItem) {
		
		boolean merged = false;
		
		for (Item item : pItems) {
			if(pItem.getSkuid() == item.getSkuid()) {
				item.setQty(pItem.getQty() + item.getQty());
				merged = true;
				break;
			}
		}
		
		return merged; 
	}

}
