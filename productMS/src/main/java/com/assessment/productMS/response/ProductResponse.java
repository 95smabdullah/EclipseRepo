package com.assessment.productMS.response;

import com.assessment.productMS.entity.Product;



public class ProductResponse {
	private int id;
	private String name;
	private String category;
	private OrderResponse orderResponse;
	
	public ProductResponse(Product p) {
		
		this.id = p.getId();
		this.name = p.getName();
		this.category = p.getCategory();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public OrderResponse getOrderResponse() {
		return orderResponse;
	}
	public void setOrderResponse(OrderResponse orderResponse) {
		this.orderResponse = orderResponse;
	}
	
	
	

}
