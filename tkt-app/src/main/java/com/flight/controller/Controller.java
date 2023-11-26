package com.flight.controller;

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

import com.flight.request.*;
import com.flight.response.*;
import com.flight.service.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fly")
public class Controller {
	
	@Autowired	BookingServices bs;
	@Autowired	FlightServices fs;
	@Autowired UserServices us;
	
	@PostMapping("/create/flight")
	public FlightResponse createFlight(@RequestBody FlightRequest flightRequest) {
		return fs.create(flightRequest);
	}
	
	@PostMapping("/create/booking")
	public BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
		return bs.create(bookingRequest);
	}
	
	@PostMapping("/create/user")
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return us.create(userRequest);
	}
	
	@PostMapping("/login")
	public UserResponse login(@RequestBody UserRequest userRequest) {
		return us.login(userRequest.getUser(), userRequest.getPassword());
	}
	
	@GetMapping("/listFlights")
	public List<FlightResponse> listAllFlight(){
		return fs.findAll();
	}
	
	@GetMapping("/listBookings/{userId}")
	public List<BookingResponse> listAllBookings(@PathVariable int userId){
		return bs.findByUserId(userId);
	}
	
	@DeleteMapping("/delete/flight/{id}")
	public void deleteFlight(@PathVariable int id) {
		fs.delete(id);
	}
	
	@DeleteMapping("/delete/booking/{id}")
	public void deleteBooking(@PathVariable int id) {
		bs.delete(id);
	}
	
	@PutMapping("/update/flight/{id}")
	public FlightResponse updateFlight(@PathVariable int id, @RequestBody FlightRequest flightRequest) {
		return fs.update(id, flightRequest);
	}
	
	
	
	
}
