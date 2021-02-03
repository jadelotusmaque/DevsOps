package com.accenture.ws.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.ws.entity.Order;

public abstract class OrderBill {
	List<Order> orderList;
	CafeClerk clerk;
	
	public OrderBill(CafeClerk clerk,List<Order> list){
		this.clerk=clerk;
		this.orderList=list;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public CafeClerk getClerk() {
		return clerk;
	}
	
	public abstract double getTotalBill();
	
	
	
 
}


