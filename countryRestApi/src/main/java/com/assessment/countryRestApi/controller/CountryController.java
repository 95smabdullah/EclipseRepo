package com.assessment.countryRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.countryRestApi.request.CountryRequest;
import com.assessment.countryRestApi.response.CountryResponse;
import com.assessment.countryRestApi.service.CountryServices;

@RestController
@RequestMapping("/api/country")
public class CountryController {
	
	@Autowired
	CountryServices cs;
	
	@PostMapping("/create")
	public CountryResponse create(@RequestBody CountryRequest cRequest) {
		return cs.create(cRequest);
	}
	
	@GetMapping("/getById/{id}")
	public CountryResponse getById(@PathVariable int id) {
		return cs.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<CountryResponse> getAll(){
		return cs.getAll();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable int id) {
		cs.delete(id);
	}
	
	@PutMapping("/updateById/{id}")
	public CountryResponse update(@PathVariable int id, @RequestBody CountryRequest cRequest) {
		return cs.updateById(id, cRequest);
	}

}
