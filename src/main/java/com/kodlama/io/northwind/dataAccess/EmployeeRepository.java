package com.kodlama.io.northwind.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.northwind.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByFirstName(String name);
	
	List<Employee> getByFirstName(String name);
}
