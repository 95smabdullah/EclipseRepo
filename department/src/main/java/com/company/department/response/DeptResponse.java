package com.company.department.response;

import com.company.department.entity.Department;

public class DeptResponse {
	
	private int id;
	private String name;
	private String location;
	
	
	
	public DeptResponse(Department dept) {
		this.id = dept.getId();
		this.name = dept.getName();
		this.location = dept.getLocation();
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
