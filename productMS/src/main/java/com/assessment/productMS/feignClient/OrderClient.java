package com.assessment.productMS.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assessment.productMS.response.OrderResponse;



//@FeignClient(url="${department.service.url}", value="DEPARTMENT-SERVICE",path="/")
@FeignClient( value="ORDER-SERVICE",path="/api/order")
public interface OrderClient {
	
	@GetMapping("/getById/{id}")
	public OrderResponse getById(@PathVariable int id);

	}

