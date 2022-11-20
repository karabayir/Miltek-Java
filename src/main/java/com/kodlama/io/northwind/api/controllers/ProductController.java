package com.kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.northwind.business.ProductService;
import com.kodlama.io.northwind.business.requests.CreateProductRequest;
import com.kodlama.io.northwind.business.requests.DeleteProductRequest;
import com.kodlama.io.northwind.business.requests.GetProductRequest;
import com.kodlama.io.northwind.business.requests.UpdateProductRequest;
import com.kodlama.io.northwind.business.responses.CreateProductResponse;
import com.kodlama.io.northwind.business.responses.GetAllProductResponse;
import com.kodlama.io.northwind.business.responses.GetProductResponse;
import com.kodlama.io.northwind.business.responses.UpdateProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products/")
@AllArgsConstructor
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("getAll")
	public List<GetAllProductResponse> getAll(){
		return productService.getAll();
	}
	
	@GetMapping("getProductByName")
	public GetProductResponse getByName(GetProductRequest request) {
		return productService.getByName(request);
	}
	
	@GetMapping("getProductById")
	public GetProductResponse getById(GetProductRequest request) {
		return productService.getById(request);
	}
	
	@PostMapping("addProduct")
	public CreateProductResponse add(CreateProductRequest request) {
		return productService.add(request);
	}
	
	@PutMapping("updateProduct/{id}")
	public UpdateProductResponse updateProductById(UpdateProductRequest request) {
		return productService.updateProductById(request);
	}
	
	@DeleteMapping("deleteProduct")
	public void deleteProductById(DeleteProductRequest request) {
		 productService.deleteProductById(request);
	}
	
	@GetMapping("getProductListByName")
	List<GetAllProductResponse> findByName(GetProductRequest request){
		return productService.findByNameToList(request);
	}
}
