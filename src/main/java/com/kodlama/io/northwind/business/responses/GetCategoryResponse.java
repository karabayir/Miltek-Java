package com.kodlama.io.northwind.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryResponse {

	private int id;
	private String name;
	private List<GetAllProductResponse> products;
	
}
