package com.accenture.ws.impl;

import java.util.ArrayList;
import java.util.List;

import com.accenture.ws.entity.Order;

public class RegularBill extends OrderBill{

	
	
	double regularBill;
	
	public RegularBill(CafeClerk clerk,List<Order> list) {
		super(clerk,list);
	}

	public double getTotalBill() {
		List<Order> order_list=new ArrayList<Order>();
		order_list=getOrderList();
		double total_bill = 0;
		for(Order order:order_list) {
				total_bill = total_bill + order.getPrice();
		}
		regularBill=total_bill;
		
		return regularBill;
	}
}
