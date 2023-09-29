package com.company.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee.request.EmpRequest;
import com.company.employee.response.EmpResponse;
import com.company.employee.services.EmpService;

@RestController
@RequestMapping("/api/employee")
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	
	@PostMapping("/create")
	public EmpResponse createEmployee(@RequestBody EmpRequest empRequest) {
		return empService.createEmp(empRequest);	
	}
	
	@GetMapping("getById/{id}")
	public EmpResponse getById (@PathVariable int id) {
		return empService.getById(id);
	}
	

}
