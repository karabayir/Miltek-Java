package com.kodlama.io.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

	private String firstName;
	private String lastName;
	private double salary;
}
