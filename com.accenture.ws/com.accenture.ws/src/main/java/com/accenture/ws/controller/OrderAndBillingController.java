package com.accenture.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.ws.entity.Order;
import com.accenture.ws.impl.CafeClerk;
import com.accenture.ws.impl.DiscountedBill;
import com.accenture.ws.impl.RegularBill;
import com.accenture.ws.repository.OrderRepository;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class OrderAndBillingController {
	
	
	@Autowired
	OrderRepository orderRepo;
	
	
	CafeClerk clerk;
	List<Order> ordering;
	double regularbill;
	double discountedbill;
	
	
	public OrderAndBillingController(){
		
		this.clerk=new CafeClerk("Jane Doe");
	}
	
	
	@GetMapping("getorderlist")
	public List<Order> getOrderList(){
		ordering= new ArrayList<Order>();
		ordering=orderRepo.findAll();
		return ordering;
	}
	
	@PostMapping("addorder")
	public void addOrder(@RequestBody Order order) {
		orderRepo.save(order);
		
	}
	
	@PutMapping("updateorder")
	public void updateOrder(@RequestBody Order order) {
		orderRepo.save(order);
	}
	
	
	@DeleteMapping("/deleteorderById/{id}")
	public void deletOrder(@PathVariable int id) {
		
		long order_id=id;
		orderRepo.deleteById(order_id);
	}
			@GetMapping("/getRegularBill") 
		public RegularAndDiscount getTotalRegularBill() {
		  
			RegularBill regular=new RegularBill(clerk,ordering);
			regular.setOrderList(ordering); 
			this.regularbill=regular.getTotalBill();
			DiscountedBill discounted=new DiscountedBill(clerk,ordering);
			discounted.setOrderList(ordering); 
			this.discountedbill=discounted.getTotalBill();
			return new RegularAndDiscount(this.clerk.name,this.regularbill,this.discountedbill);
			  
		}
		 
	  
}
