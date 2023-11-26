package com.example.CrudEmployeeRestHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudEmployeeRestHibernate.entities.Employee;
import com.example.CrudEmployeeRestHibernate.repos.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeRepo empRepo;
	
	public List<Employee> get(){
		return empRepo.findAll();
	}
	public Employee get(int id) {
		return empRepo.findById(id).orElse(null);
	}
	public void save(Employee employee) {
		empRepo.save(employee);
	}
	public void delete(int id) {
		empRepo.deleteById(id);
	}
	
	public Employee update(int id, Employee updatedEmp) {
		Employee existingEmp = empRepo.findById(id).orElse(null);
		if(existingEmp!= null) {
			existingEmp.setName(updatedEmp.getName());
			existingEmp.setEmail(updatedEmp.getEmail());
			existingEmp.setDob(updatedEmp.getDob());
			return empRepo.save(existingEmp);
		}
		return null;
		
	}



}
