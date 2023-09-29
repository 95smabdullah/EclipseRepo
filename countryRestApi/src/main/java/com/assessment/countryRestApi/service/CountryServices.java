package com.assessment.countryRestApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assessment.countryRestApi.entity.Country;
import com.assessment.countryRestApi.repository.CountryRepo;
import com.assessment.countryRestApi.request.CountryRequest;
import com.assessment.countryRestApi.response.CountryResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CountryServices {
	
	@Autowired
	CountryRepo cr;

	public CountryResponse getById(int id) {
		
		Country c = cr.findById(id).get();
		
		return new CountryResponse(c);
	}
	
	public CountryResponse create(CountryRequest cRequest) {
		
		Country c = new Country();
		c.setName(cRequest.getName());
		c.setPopulation(cRequest.getPopulation());
		c = cr.save(c);
		
		return new CountryResponse(c);
	}
	
	public List<CountryResponse> getAll(){
		
		List<Country> lc = cr.findAll();
		List<CountryResponse> countryResponseList = new ArrayList<CountryResponse>();
		for (Country c : lc) {
			countryResponseList.add(new CountryResponse(c));			
		}
		
		return countryResponseList;
	}
	
	public CountryResponse updateById(int id, CountryRequest cRequest) {
		Country c = cr.findById(id).get();
		c.setName(cRequest.getName());
		c.setPopulation(cRequest.getPopulation());
		c = cr.save(c);
		return new CountryResponse(c);
		
		
	}
	
	
	public void delete(int id) {
		
		cr.deleteById(id);
	}
	
}
