package com.example.CrudEmployeeRestHibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CrudEmployeeRestHibernate.entities.Employee;
import com.example.CrudEmployeeRestHibernate.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	@GetMapping
	public List<Employee> getAllEmps(){
		return empService.get();	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable int id){
		Employee emp = empService.get(id);
		if(emp!=null) {
			return ResponseEntity.ok(emp);
		}else return ResponseEntity.notFound().build();	
	}
	@PostMapping
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
		empService.save(emp);
		return ResponseEntity.ok(emp);	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable int id){
		empService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id, @RequestBody Employee emp){
		Employee updated = empService.update(id, emp);
		if(updated!=null) {
			return ResponseEntity.ok(updated);
		} else return ResponseEntity.notFound().build();
	}	
}
