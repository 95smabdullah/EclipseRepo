package com.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.Booking;
import com.flight.repository.BookingRepo;
import com.flight.request.BookingRequest;
import com.flight.response.BookingResponse;
@Service
public class BookingServices {
	
	@Autowired
	BookingRepo br;
	@Autowired
	FlightServices fs;
	
	public BookingResponse create(BookingRequest bookingRequest) {
		Booking b = new Booking();
		b.setFlightId(bookingRequest.getFlightId());
		b.setUserId(bookingRequest.getUserId());
		b=br.save(b);
		BookingResponse bookingResponse = new BookingResponse(b);
		bookingResponse.setFlightResponse(fs.findById(bookingResponse.getFlightId()));
		return bookingResponse;
	}
	
	public List<BookingResponse> findByUserId(int userId){
		List<Booking> lb = br.findAllByUserId(userId);
		System.out.println(userId);
		System.out.println(lb.toString());
		List<BookingResponse> lbr = new ArrayList<BookingResponse>();
		for (Booking b : lb) {
			BookingResponse bookingResponse = new BookingResponse(b);
			bookingResponse.setFlightResponse(fs.findById(bookingResponse.getFlightId()));
			lbr.add(bookingResponse);			
		}
		return lbr;
	}
	
	public void delete(int id) {
		br.deleteById(id);
	}
}
