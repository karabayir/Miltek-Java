package com.kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.northwind.business.EmployeeService;
import com.kodlama.io.northwind.business.requests.CreateEmployeeRequest;
import com.kodlama.io.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlama.io.northwind.business.requests.GetEmployeeRequest;
import com.kodlama.io.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.northwind.business.responses.CreateEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetEmployeeResponse;
import com.kodlama.io.northwind.business.responses.UpdateEmployeeResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/employess/")
@AllArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@GetMapping("getAll")
	public List<GetAllEmployeeResponse> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("getEmployeeByName")
	public GetEmployeeResponse getByName(GetEmployeeRequest request) {
		return employeeService.getByName(request);
	}
	
	@GetMapping("getEmployeeById")
	public GetEmployeeResponse getById(GetEmployeeRequest request) {
		return employeeService.getById(request);
	}
	
	@PostMapping("addEmployee")
	public CreateEmployeeResponse add(CreateEmployeeRequest request) {
		return employeeService.add(request);
	}
	
	@PutMapping("updateEmployee")
	public UpdateEmployeeResponse updateCategoryById(UpdateEmployeeRequest request) {
		return employeeService.updateCategoryById(request);
	}
	
	@DeleteMapping("deleteEmployee")
	public void deleteEmployeeById(DeleteEmployeeRequest request) {
		employeeService.deleteEmployeeById(request);
	}
	
	@GetMapping("getEmployeeListByName")
	public List<UpdateEmployeeResponse> findByNameToList(GetEmployeeRequest request){
		return employeeService.findByNameToList(request);
	}
}
