package com.flight.response;

import com.flight.entity.Booking;

import lombok.Data;

@Data
public class BookingResponse {
	private int id;
	private int userId;
	private int flightId;
	private FlightResponse flightResponse;
	public BookingResponse(Booking b) {
		super();
		this.id = b.getId();
		this.userId = b.getUserId();
		this.flightId = b.getFlightId();
	}
	
	

}
