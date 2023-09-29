package com.assessment.customerMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.customerMS.request.CustomerRequest;
import com.assessment.customerMS.response.CustomerResponse;
import com.assessment.customerMS.service.CustomerServices;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerServices cs;
	
	@PostMapping("/create")
	public CustomerResponse create(@RequestBody CustomerRequest cRequest) {
		return cs.create(cRequest);
	}
	
	@GetMapping("/getById/{id}")
	public CustomerResponse getById(@PathVariable int id) {
		return cs.getById(id);
	}
}
