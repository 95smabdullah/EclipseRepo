package com.assessment.productMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.productMS.request.ProductRequest;
import com.assessment.productMS.response.ProductResponse;
import com.assessment.productMS.service.ProductServices;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductServices pr;
	
	@PostMapping("/create")
	public ProductResponse create(@RequestBody ProductRequest pRequest) {
		return pr.create(pRequest);
	}
	
	@GetMapping("/getById/{id}")
	public ProductResponse getById(@PathVariable int id) {
		return pr.getById(id);
	}
}
