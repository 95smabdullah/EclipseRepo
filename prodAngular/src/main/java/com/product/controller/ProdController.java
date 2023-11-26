package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.request.ProdRequest;
import com.product.request.UserRequest;
import com.product.response.ProdResponse;
import com.product.response.UserResponse;
import com.product.service.ProdServices;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProdController {
	
	@Autowired
	ProdServices ps;
	
	@PostMapping("/create")
	public ProdResponse create(@RequestBody ProdRequest prodRequest) {
		return ps.create(prodRequest);
	}
	
	@GetMapping("/findById/{id}")
	public ProdResponse findById(@PathVariable int id) {
		return ps.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<ProdResponse> findAll(){
		return ps.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ProdResponse update(@PathVariable int id, @RequestBody ProdRequest prodRequest) {
		return ps.update(id, prodRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		ps.delete(id);
	}
	@PostMapping("/login")
	public UserResponse login(@RequestBody UserRequest userRequest) {
		return ps.login(userRequest.getUser(), userRequest.getPassword());
	}
}
