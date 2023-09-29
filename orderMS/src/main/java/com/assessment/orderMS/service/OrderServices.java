package com.assessment.orderMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.orderMS.entity.Order;
import com.assessment.orderMS.repository.OrderRepo;
import com.assessment.orderMS.request.OrderRequest;
import com.assessment.orderMS.response.OrderResponse;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepo or;
	
	public OrderResponse getById(int id) {
		return new OrderResponse(or.findById(id).get());
	}
	
	public OrderResponse create(OrderRequest oRequest) {
		Order o = new Order();
		o.setStatus(oRequest.getStatus());
		o.setQty(oRequest.getQty());
		o = or.save(o);
		return new OrderResponse(o);
	}
}
