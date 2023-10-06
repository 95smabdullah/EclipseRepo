package com.flight.request;

import lombok.Data;

@Data
public class FlightRequest {
	private String name;
	private String src;
	private String dest;
	private int fare;
}
