package com.assessment.orderMS.response;

import com.assessment.orderMS.entity.Order;

public class OrderResponse {
	private int id;
	private int qty;
	private String status;
	public OrderResponse(Order o) {
		
		this.id = o.getId();
		this.qty = o.getQty();
		this.status = o.getStatus();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
