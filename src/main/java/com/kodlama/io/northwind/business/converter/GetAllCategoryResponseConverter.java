package com.kodlama.io.northwind.business.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kodlama.io.northwind.business.responses.GetAllCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllProductResponse;
import com.kodlama.io.northwind.entities.Category;

@Component
public class GetAllCategoryResponseConverter {
	
	
	public GetAllCategoryResponse convert(Category category) {
		return new GetAllCategoryResponse(
				category.getId(), 
				category.getName(), 
				category.getProducts()
				.stream()
				.map(p -> new GetAllProductResponse(
						p.getId(),
						p.getName() , 
						p.getCategory().getName(), 
						p.getUnitsInStock(), 
						p.getUnitPrice())).collect(Collectors.toList())
				);
	}
}
