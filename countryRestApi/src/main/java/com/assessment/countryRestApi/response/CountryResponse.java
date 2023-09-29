package com.assessment.countryRestApi.response;

import com.assessment.countryRestApi.entity.Country;

import jakarta.persistence.Column;

public class CountryResponse {
	
	private int id;
	private String name;
	private int population;
	
	
	
	public CountryResponse(Country c) {
		this.id = c.getId();
		this.name = c.getName();
		this.population = c.getPopulation();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	

}
