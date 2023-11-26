package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.entity.User;
import com.flight.repository.UserRepo;
import com.flight.request.UserRequest;
import com.flight.response.UserResponse;
@Service
public class UserServices {
	@Autowired
	UserRepo ur;
	
	
	public UserResponse create(UserRequest userRequest) {
		User u = new User();
		u.setUser(userRequest.getUser());
		u.setPassword(userRequest.getPassword());
		u=ur.save(u);
		return new UserResponse(u);
	}
	
	public UserResponse login(String user, String password) {
		User u = ur.findByUserAndPassword(user, password);
		if(u!=null)	return new UserResponse(u);
		else return new UserResponse(new User());
		
	}

}
