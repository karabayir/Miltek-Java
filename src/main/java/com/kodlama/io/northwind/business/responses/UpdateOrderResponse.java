package com.kodlama.io.northwind.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderResponse {

	private int id;
	private LocalDate date;
	private int employeeId;
}
