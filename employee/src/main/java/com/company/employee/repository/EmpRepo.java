package com.company.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.employee.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
