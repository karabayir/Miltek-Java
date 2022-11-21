package com.kodlama.io.northwind.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
	
	private int id;
	private String name;
	private String categoryName;
	private int unitsInStocks;
	//private double unitPrice;

}
