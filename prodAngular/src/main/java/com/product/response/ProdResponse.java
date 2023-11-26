package com.product.response;

import com.product.entity.Product;

import lombok.Data;

@Data
public class ProdResponse {
	private int id;
	private String name;
	private int price;
	public ProdResponse(Product p) {
		
		this.id = p.getId();
		this.name = p.getName();
		this.price = p.getPrice();
	}
	
	
}
