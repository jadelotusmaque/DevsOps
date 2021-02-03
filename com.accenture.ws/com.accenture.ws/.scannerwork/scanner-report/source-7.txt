package com.accenture.ws.impl;

import java.util.ArrayList;
import java.util.List;

import com.accenture.ws.controller.OrderAndBillingController;
import com.accenture.ws.entity.Order;

public class DiscountedBill extends OrderBill{
	
	

	
	
	
	public DiscountedBill(CafeClerk clerk, List<Order> list) {
		super(clerk, list);
		// TODO Auto-generated constructor stub
	}

	public double getTotalBill() {
		List<Order> order_list=new ArrayList<Order>();
		order_list=getOrderList();
		double total_bill = 0;
		double discount=0;
		for(Order order:order_list) {
			if(order.isDiscounted()) {
				discount=order.getPrice()*0.05;
				total_bill = total_bill + order.getPrice()-discount;
			}
			discount=0;
		}
		
		return total_bill;
	}
	
	
}
