package com.kodlama.io.northwind.business.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kodlama.io.northwind.business.responses.GetAllEmployeeResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.entities.Employee;

@Component
public class GetAllEmployeeResponseConverter {
	
	public GetAllEmployeeResponse convert(Employee employee) {
		
		return new GetAllEmployeeResponse(
				employee.getId(), 
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getSalary(), 
				employee.getOrders()
				.stream()
				.map(o-> new GetAllOrderResponse(
						o.getId(),
						o.getDate(),
						o.getEmployee().getId()))
				.collect(Collectors.toList()));		
	}

}
