package com.kodlama.io.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductResponse {
	
	private int id;
	private int categoryId;
	private int unitsInStock;
	private String name;
	private double unitPrice;

}
