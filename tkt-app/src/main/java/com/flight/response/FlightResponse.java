package com.flight.response;

import com.flight.entity.Flight;

import lombok.Data;

@Data
public class FlightResponse {
	private int id;
	private String name;
	private String src;
	private String dest;
	private int fare;
	public FlightResponse(Flight f) {
		super();
		this.id = f.getId();
		this.name = f.getName();
		this.src = f.getSrc();
		this.dest = f.getDest();
		this.fare = f.getFare();
	}
	
	
	
}
