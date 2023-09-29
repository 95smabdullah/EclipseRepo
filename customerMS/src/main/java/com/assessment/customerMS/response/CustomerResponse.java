package com.assessment.customerMS.response;

import com.assessment.customerMS.entity.Customer;

public class CustomerResponse {
	
	private int id;
	private String name;
	private String email;
	private ProductResponse productResponse;
	public CustomerResponse(Customer c) {
		this.id = c.getId();
		this.name = c.getName();
		this.email = c.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ProductResponse getProductResponse() {
		return productResponse;
	}
	public void setProductResponse(ProductResponse productResponse) {
		this.productResponse = productResponse;
	}
	
	
	
	
}
