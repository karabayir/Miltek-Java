package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.converter.GetAllEmployeeResponseConverter;
import com.kodlama.io.northwind.business.requests.CreateEmployeeRequest;
import com.kodlama.io.northwind.business.requests.DeleteEmployeeRequest;
import com.kodlama.io.northwind.business.requests.GetEmployeeRequest;
import com.kodlama.io.northwind.business.requests.UpdateEmployeeRequest;
import com.kodlama.io.northwind.business.responses.CreateEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.business.responses.GetEmployeeResponse;
import com.kodlama.io.northwind.business.responses.UpdateEmployeeResponse;
import com.kodlama.io.northwind.dataAccess.EmployeeRepository;
import com.kodlama.io.northwind.entities.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final GetAllEmployeeResponseConverter converter;

	@Override
	public List<GetAllEmployeeResponse> getAll() {
		
		return employeeRepository.findAll()
				.stream()
				.map(e-> converter.convert(e))
				.collect(Collectors.toList());
	}

	@Override
	public GetEmployeeResponse getByName(GetEmployeeRequest request) {
		Employee employee = employeeRepository.findByFirstName(request.getEmployeeName());

		List<GetAllOrderResponse> orders= orderToOrderResponseInEmployee(employee);
		
		return new GetEmployeeResponse(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(),
				employee.getSalary(), 
				orders
				);
	}

	@Override
	public GetEmployeeResponse getById(GetEmployeeRequest request) {
		Employee employee = employeeRepository.findById(request.getEmployeeId()).orElseThrow();
		
		List<GetAllOrderResponse> orders= orderToOrderResponseInEmployee(employee);
		
		return new GetEmployeeResponse(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(),
				employee.getSalary(), 
				orders
				);
	}

	@Override
	public CreateEmployeeResponse add(CreateEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setSalary(request.getSalary());
		
		employeeRepository.save(employee);
		
		return new CreateEmployeeResponse(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getSalary());
	}

	@Override
	public UpdateEmployeeResponse updateCategoryById(UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		employee.setId(request.getEmployeeId());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setSalary(request.getSalary());
		
		employeeRepository.save(employee);

		return new UpdateEmployeeResponse(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getSalary());
	}

	@Override
	public void deleteEmployeeById(DeleteEmployeeRequest request) {
		 employeeRepository.deleteById(request.getEmployeeId());
		
	}
	
	private List<GetAllOrderResponse> orderToOrderResponseInEmployee(Employee employee){
		      return employee.getOrders()
				.stream()
				.map(o-> new GetAllOrderResponse(
						o.getId(),
						o.getDate(), 
						o.getEmployee().getId()))
				.collect(Collectors.toList());
	}

	@Override
	public List<UpdateEmployeeResponse> findByNameToList(GetEmployeeRequest request) {
		return employeeRepository.getByFirstName(request.getEmployeeName())
				.stream()
				.map(e-> new UpdateEmployeeResponse(
						e.getId(), 
						e.getFirstName(),
						e.getLastName(),
						e.getSalary()))
				.collect(Collectors.toList());
	}

}
