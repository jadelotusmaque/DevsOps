package com.accenture.ws.controller;

public class RegularAndDiscount {
	String clerk;
	double regular;
	double discounted;
	public RegularAndDiscount(String clerk, double regular, double discounted) {
		super();
		this.clerk = clerk;
		this.regular = regular;
		this.discounted = discounted;
	}
	public String getClerk() {
		return clerk;
	}
	public void setClerk(String clerk) {
		this.clerk = clerk;
	}
	public double getRegular() {
		return regular;
	}
	public void setRegular(double regular) {
		this.regular = regular;
	}
	public double getDiscounted() {
		return discounted;
	}
	public void setDiscounted(double discounted) {
		this.discounted = discounted;
	}
	
	
	

	
	
	
	
}
