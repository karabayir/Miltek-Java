package com.kodlama.io.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

	//private int id;
	private int categoryId;
	private String name;
	private int unitsInStock;
	private double unitPrice;
}
