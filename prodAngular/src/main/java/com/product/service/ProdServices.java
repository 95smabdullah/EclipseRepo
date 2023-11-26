package com.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.ProdRepo;
import com.product.repository.UserRepo;
import com.product.request.ProdRequest;
import com.product.response.ProdResponse;
import com.product.response.UserResponse;
@Service
public class ProdServices {
	@Autowired
	ProdRepo pr;
	
	@Autowired
	UserRepo ur;
	
	public ProdResponse create(ProdRequest prodRequest) {
		Product p = new Product();
		p.setName(prodRequest.getName());
		p.setPrice(prodRequest.getPrice());
		p=pr.save(p);
		return new ProdResponse(p);
	}
	
	public ProdResponse findById(int id) {
		Product p = pr.findById(id).get();
		return new ProdResponse(p);
	}
	
	public List<ProdResponse> findAll(){
		List<Product> lp = pr.findAll();
		List<ProdResponse> lpr = new ArrayList<ProdResponse>();
		for (Product p : lp) {
			lpr.add(new ProdResponse(p));			
		}
		return lpr;
	}
	
	public ProdResponse update(int id,ProdRequest prodRequest) {
		Product p = pr.findById(id).get();
		p.setName(prodRequest.getName());
		p.setPrice(prodRequest.getPrice());
		p=pr.save(p);
		return new ProdResponse(p);
	}
	
	public void delete(int id) {
		pr.deleteById(id);
	}
	
	public UserResponse login(String user, String password) {
		User u = ur.findByUserAndPassword(user, password);
		if(u!=null)	return new UserResponse(u);
		else return new UserResponse(new User());
		
	}
}
