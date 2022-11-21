package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.requests.CreateEmployeeRequest;
import com.kodlama.io.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlama.io.northwind.business.requests.GetEmployeeRequest;
import com.kodlama.io.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.northwind.business.responses.CreateEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.business.responses.GetEmployeeResponse;
import com.kodlama.io.northwind.business.responses.UpdateEmployeeResponse;
import com.kodlama.io.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.northwind.dataAccess.EmployeeRepository;
import com.kodlama.io.northwind.entities.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapperService mapperService;

	@Override
	public List<GetAllEmployeeResponse> getAll() {
		
		return employeeRepository.findAll()
				.stream()
				.map(e-> mapperService.forResponse().map(e, GetAllEmployeeResponse.class)) //
				.collect(Collectors.toList());
	}
	@Override
	public GetEmployeeResponse getByName(GetEmployeeRequest request) {
		Employee employee = employeeRepository.findByFirstName(request.getEmployeeName());

		List<GetAllOrderResponse> orders= employee.getOrders()
				.stream()
				.map(o-> mapperService.forResponse().map(o, GetAllOrderResponse.class))
				.collect(Collectors.toList());
		
		GetEmployeeResponse response= mapperService.forResponse().map(employee, GetEmployeeResponse.class);
		response.setOrders(orders);
		
		return response;
	}

	@Override
	public GetEmployeeResponse getById(GetEmployeeRequest request) {
		Employee employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
		
		List<GetAllOrderResponse> orders= employee.getOrders()
				.stream()
				.map(o-> mapperService.forResponse().map(o, GetAllOrderResponse.class))
				.collect(Collectors.toList());
		
		GetEmployeeResponse response= mapperService.forResponse().map(employee, GetEmployeeResponse.class);
		response.setOrders(orders);
		
		return response;
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest request) {
		Employee employee = mapperService.forRequest().map(request, Employee.class);
		
		employeeRepository.save(employee);
		
		return mapperService.forResponse().map(employee, CreateEmployeeResponse.class);
	}

	@Override
	public UpdateEmployeeResponse updateCategoryById(UpdateEmployeeRequest request) {
		Employee employee =mapperService.forRequest().map(request, Employee.class);
		
		employeeRepository.save(employee);

		return mapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
	}

	@Override
	public void deleteEmployeeById(DeleteEmployeeRequest request) {
		 employeeRepository.deleteById(request.getEmployeeId());
		
	}
	@Override
	public List<UpdateEmployeeResponse> findByNameToList(GetEmployeeRequest request) {
		return employeeRepository.getByFirstName(request.getEmployeeName())
				.stream()
				.map(e-> mapperService.forResponse().map(e, UpdateEmployeeResponse.class))
				.collect(Collectors.toList());
	}

}
