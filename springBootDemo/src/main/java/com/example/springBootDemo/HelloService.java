package com.example.springBootDemo;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	public String HelloMessage() {
	return "Hello from spring Boot Service";
	}

}
