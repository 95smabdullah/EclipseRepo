package com.assessment.productMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.productMS.entity.Product;
import com.assessment.productMS.feignClient.OrderClient;
import com.assessment.productMS.repository.ProductRepo;
import com.assessment.productMS.request.ProductRequest;
import com.assessment.productMS.response.ProductResponse;

@Service
public class ProductServices {
	
	@Autowired
	ProductRepo pr;
	
	@Autowired
	OrderClient oc;
	
	public ProductResponse create(ProductRequest pRequest) {
		Product p = new Product();
		p.setCategory(pRequest.getCategory());
		p.setName(pRequest.getName());
		p.setOrderId(pRequest.getOrderId());
		p = pr.save(p);
		ProductResponse pResponse = new ProductResponse(p);
		pResponse.setOrderResponse(oc.getById(p.getOrderId()));
		return pResponse;	
	}
	
	public ProductResponse getById(int id) {
		Product p = pr.findById(id).get();
		ProductResponse pResponse = new ProductResponse(p);
		pResponse.setOrderResponse(oc.getById(p.getOrderId()));
		return pResponse;
	}

}
