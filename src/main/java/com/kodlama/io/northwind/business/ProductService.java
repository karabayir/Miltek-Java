package com.kodlama.io.northwind.business;

import java.util.List;

import com.kodlama.io.northwind.business.requests.CreateProductRequest;
import com.kodlama.io.northwind.business.requests.DeleteProductRequest;
import com.kodlama.io.northwind.business.requests.GetProductRequest;
import com.kodlama.io.northwind.business.requests.UpdateProductRequest;
import com.kodlama.io.northwind.business.responses.CreateProductResponse;
import com.kodlama.io.northwind.business.responses.GetAllProductResponse;
import com.kodlama.io.northwind.business.responses.GetProductResponse;
import com.kodlama.io.northwind.business.responses.UpdateProductResponse;

public interface ProductService {

	List<GetAllProductResponse> getAll();
	
	CreateProductResponse add(CreateProductRequest request);
	
	GetProductResponse getByName(GetProductRequest request);
	
	GetProductResponse getById(GetProductRequest request);
	
	void deleteProductById(DeleteProductRequest request);
	
	UpdateProductResponse updateProductById(UpdateProductRequest request);
	
	List<GetAllProductResponse> findByNameToList(GetProductRequest request);
	
}
