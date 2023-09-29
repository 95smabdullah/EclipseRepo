package com.company.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.department.entity.Department;
import com.company.department.repository.DeptRepo;
import com.company.department.request.DeptRequest;
import com.company.department.response.DeptResponse;

@Service
public class DeptService {
	
	@Autowired
	DeptRepo deptRepo;
	
	public DeptResponse createDept(DeptRequest deptRequest) {
		Department newDept = new Department();
		newDept.setName(deptRequest.getName());
		newDept.setLocation(deptRequest.getLocation());
		newDept = deptRepo.save(newDept);
		return new DeptResponse(newDept);
	}
	
	public DeptResponse getDept(int id) {
		return new DeptResponse(deptRepo.findById(id).get());
	}
}
