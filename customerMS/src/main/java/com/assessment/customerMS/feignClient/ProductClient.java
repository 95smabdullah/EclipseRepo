package com.assessment.customerMS.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assessment.customerMS.response.ProductResponse;



//@FeignClient(url="${department.service.url}", value="DEPARTMENT-SERVICE",path="/")
@FeignClient( value="PRODUCT-SERVICE",path="/api/product")
public interface ProductClient {
	
	@GetMapping("/getById/{id}")
	public ProductResponse getById(@PathVariable int id);

	}
