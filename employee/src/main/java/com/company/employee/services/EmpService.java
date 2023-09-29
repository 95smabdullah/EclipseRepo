package com.company.employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.company.employee.entity.Employee;
import com.company.employee.feignclient.DeptFeignClient;
import com.company.employee.repository.EmpRepo;
import com.company.employee.request.EmpRequest;
import com.company.employee.response.DeptResponse;
import com.company.employee.response.EmpResponse;


@Service
public class EmpService {
	
	
	@Autowired
	EmpRepo empRepo;
	@Autowired
	WebClient webClient;
	@Autowired
	DeptFeignClient deptFeignClient;
	
	
	public EmpResponse createEmp(EmpRequest empRequest) {
		Employee newEmp = new Employee();
		
		newEmp.setName(empRequest.getName());
		newEmp.setAge(empRequest.getAge());
		newEmp.setSalary(empRequest.getSalary());
		newEmp.setDeptId(empRequest.getDeptId());
		newEmp = empRepo.save(newEmp);
		EmpResponse empResponse = new EmpResponse(newEmp);
//		empResponse.setDeptResponse(getDeptResponse(newEmp.getDeptId()));
		empResponse.setDeptResponse(deptFeignClient.getById(newEmp.getDeptId()));
		return empResponse; 
	}
	
	public EmpResponse getById(int id) {
		Employee emp = empRepo.findById(id).get();
		EmpResponse empResponse = new EmpResponse(emp);
//		empResponse.setDeptResponse(getDeptResponse(emp.getDeptId()));
		empResponse.setDeptResponse(deptFeignClient.getById(emp.getDeptId()));
		return empResponse;
		
	}
	
	public DeptResponse getDeptResponse(int id) {
		return webClient.get().uri("/getById/" + id)
				.retrieve().bodyToMono(DeptResponse.class).block();
	}
	
}
