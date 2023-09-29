package com.company.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.department.entity.Department;

public interface DeptRepo extends JpaRepository<Department, Integer>{

}
