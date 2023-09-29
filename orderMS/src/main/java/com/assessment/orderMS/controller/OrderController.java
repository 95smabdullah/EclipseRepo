package com.assessment.orderMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.orderMS.request.OrderRequest;
import com.assessment.orderMS.response.OrderResponse;
import com.assessment.orderMS.service.OrderServices;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderServices os;
	
	@PostMapping("/create")
	public OrderResponse create(@RequestBody OrderRequest oRequest) {
		return os.create(oRequest);
	}
	
	@GetMapping("/getById/{id}")
	public OrderResponse getById(@PathVariable int id) {
		return os.getById(id);
	}

}
