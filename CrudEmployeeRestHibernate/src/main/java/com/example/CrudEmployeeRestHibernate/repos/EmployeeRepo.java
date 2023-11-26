package com.example.CrudEmployeeRestHibernate.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CrudEmployeeRestHibernate.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
