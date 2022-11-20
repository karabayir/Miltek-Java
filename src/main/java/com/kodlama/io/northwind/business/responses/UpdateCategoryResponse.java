package com.kodlama.io.northwind.business.responses;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCategoryResponse {

	private int id;
	private String name;
	//private List<GetAllProductResponse> products;
}
