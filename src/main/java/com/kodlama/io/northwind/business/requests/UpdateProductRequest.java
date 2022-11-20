package com.kodlama.io.northwind.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

	int productId;
	private String name;
	private double unitPrice;
	private int unitsInStock;
	private int categoryId;
}
