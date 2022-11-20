package com.kodlama.io.northwind.business;

import java.util.List;

import com.kodlama.io.northwind.business.requests.CreateEmployeeRequest;
import com.kodlama.io.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlama.io.northwind.business.requests.GetEmployeeRequest;
import com.kodlama.io.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.northwind.business.responses.CreateEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetEmployeeResponse;
import com.kodlama.io.northwind.business.responses.UpdateEmployeeResponse;

public interface EmployeeService {

	List<GetAllEmployeeResponse> getAll();
	
	GetEmployeeResponse getByName(GetEmployeeRequest request);
	
	GetEmployeeResponse getById(GetEmployeeRequest request);
	
	CreateEmployeeResponse add(CreateEmployeeRequest request);
	
	UpdateEmployeeResponse updateCategoryById(UpdateEmployeeRequest request);
	
	void deleteEmployeeById(DeleteEmployeeRequest request);
	
	List<UpdateEmployeeResponse> findByNameToList(GetEmployeeRequest employeeRequest);
}
