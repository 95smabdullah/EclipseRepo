package com.assessment.customerMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.customerMS.entity.Customer;
import com.assessment.customerMS.feignClient.ProductClient;
import com.assessment.customerMS.repository.CustomerRepo;
import com.assessment.customerMS.request.CustomerRequest;
import com.assessment.customerMS.response.CustomerResponse;

@Service
public class CustomerServices {
	
	@Autowired
	CustomerRepo cr;
	
	@Autowired
	ProductClient pc;
	
	public CustomerResponse create(CustomerRequest cRequest) {
		
		Customer c = new Customer();
		c.setName(cRequest.getName());
		c.setEmail(cRequest.getEmail());
		c.setProductId(cRequest.getProductId());
		c=cr.save(c);
		CustomerResponse cResponse = new CustomerResponse(c);
		cResponse.setProductResponse(pc.getById(c.getProductId()));
		return cResponse;
	}
	
	public CustomerResponse getById(int id) {
		Customer c = cr.findById(id).get();
		CustomerResponse cResponse = new CustomerResponse(c);
		cResponse.setProductResponse(pc.getById(c.getProductId()));
		return cResponse;
	}

}
