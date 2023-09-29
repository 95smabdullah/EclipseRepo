package com.company.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.department.request.DeptRequest;
import com.company.department.response.DeptResponse;
import com.company.department.service.DeptService;

@RestController
@RequestMapping("/api/department")
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	
	@PostMapping("/create")
	public DeptResponse createDept(@RequestBody DeptRequest deptRequest) {
		return deptService.createDept(deptRequest);
	}
	
	@GetMapping("/getById/{id}")
	public DeptResponse getDept(@PathVariable int id) {
		return deptService.getDept(id);
	}

}
