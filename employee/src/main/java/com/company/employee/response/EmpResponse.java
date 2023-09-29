package com.company.employee.response;

import com.company.employee.entity.Employee;

public class EmpResponse {
	private int id;
	private String name;
	private int age;
	private int salary;
	private DeptResponse deptResponse;
	
	
	
	public EmpResponse(Employee emp) {
		this.id = emp.getId();
		this.name = emp.getName();
		this.age = emp.getAge();
		this.salary = emp.getSalary();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public DeptResponse getDeptResponse() {
		return deptResponse;
	}
	public void setDeptResponse(DeptResponse deptResponse) {
		this.deptResponse = deptResponse;
	}
	
	

}
