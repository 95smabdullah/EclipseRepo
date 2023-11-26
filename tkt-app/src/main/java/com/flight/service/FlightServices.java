package com.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.Flight;
import com.flight.repository.BookingRepo;
import com.flight.repository.FlightRepo;
import com.flight.request.FlightRequest;
import com.flight.response.FlightResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServices {
	@Autowired	FlightRepo fr;
	@Autowired BookingRepo br;
	
	public FlightResponse create(FlightRequest flightRequest) {
		Flight f = new Flight();
		f.setName(flightRequest.getName());
		f.setSrc(flightRequest.getSrc());
		f.setDest(flightRequest.getDest());
		f.setFare(flightRequest.getFare());
		f=fr.save(f);
		return new FlightResponse(f);
	}
	
	public FlightResponse findById(int id) {
		Flight f = fr.findById(id).get();
		return new FlightResponse(f);
	}
	
	public List<FlightResponse> findAll(){
		List<Flight> lf = fr.findAll();
		List<FlightResponse> lfr = new ArrayList<FlightResponse>();
		for (Flight f : lf) {
			lfr.add(new FlightResponse(f));			
		}
		return lfr;
	}
	
	public FlightResponse update(int id,FlightRequest flightRequest) {
		Flight f = fr.findById(id).get();
		f.setName(flightRequest.getName());
		f.setSrc(flightRequest.getSrc());
		f.setDest(flightRequest.getDest());
		f.setFare(flightRequest.getFare());
		f=fr.save(f);
		return new FlightResponse(f);
	}
	
	public void delete(int id) {
		br.deleteByFlightId(id);
		fr.deleteById(id);
	}

}
