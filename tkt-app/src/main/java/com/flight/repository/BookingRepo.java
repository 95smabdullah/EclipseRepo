package com.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
	List<Booking> findAllByUserId(int userId);
	
	void deleteByFlightId(int flightId);
}
