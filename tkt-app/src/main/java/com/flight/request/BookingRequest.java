package com.flight.request;

import lombok.Data;

@Data
public class BookingRequest {
	private int userId;
	private int flightId;
	private String name;
	private String src;
	private String dest;
	private int fare;

}
