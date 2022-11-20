package com.kodlama.io.northwind.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetEmployeeResponse {

	private int id;
	private String firstName;
	private String lastName;
	private double salary;
	private List<GetAllOrderResponse> orders;
}
