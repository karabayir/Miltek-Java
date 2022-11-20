package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.requests.CreateProductRequest;
import com.kodlama.io.northwind.business.requests.DeleteProductRequest;
import com.kodlama.io.northwind.business.requests.GetProductRequest;
import com.kodlama.io.northwind.business.requests.UpdateProductRequest;
import com.kodlama.io.northwind.business.responses.CreateProductResponse;
import com.kodlama.io.northwind.business.responses.GetAllProductResponse;
import com.kodlama.io.northwind.business.responses.GetProductResponse;
import com.kodlama.io.northwind.business.responses.UpdateProductResponse;
import com.kodlama.io.northwind.dataAccess.ProductRepository;
import com.kodlama.io.northwind.entities.Category;
import com.kodlama.io.northwind.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

	private final ProductRepository productRepository;


	@Override
	public List<GetAllProductResponse> getAll() {
		
	 return	productRepository.findAll()
		.stream()
		.map(p-> new GetAllProductResponse(
				p.getId(), 
				p.getName(), 
				p.getCategory().
				getName(), 
				p.getUnitsInStock(), 
				p.getUnitPrice()))
		.collect(Collectors.toList());
	}

	@Override
	public CreateProductResponse add(CreateProductRequest request) {
		Product product = new Product();
		Category category = new Category();
		
		category.setId(request.getCategoryId());
		
		product.setName(request.getName());
		product.setUnitPrice(request.getUnitPrice());
		product.setUnitsInStock(request.getUnitsInStock());
		product.setCategory(category);
		
		productRepository.save(product);
		
		return new CreateProductResponse(
				product.getId(), 
				product.getCategory().
				getId(), 
				product.getUnitsInStock(), 
				product.getName(), 
				product.getUnitPrice());
	}

	@Override
	public GetProductResponse getByName(GetProductRequest request) {
		Product product = productRepository.findByName(request.getProductName());
		
		return new GetProductResponse(
				product.getId(), 
				product.getName(), 
				product.getCategory().getName(), 
				product.getUnitsInStock(), 
				product.getUnitPrice()) ;
	}

	@Override
	public GetProductResponse getById(GetProductRequest request) {
		Product product = productRepository.findById(request.getProductId()).orElseThrow();
		return new GetProductResponse(
				product.getId(), 
				product.getName(), 
				product.getCategory().getName(), 
				product.getUnitsInStock(), 
				product.getUnitPrice()) ;
	}

	@Override
	public void deleteProductById(DeleteProductRequest request) {
		productRepository.deleteById(request.getProductId());
	}

	@Override
	public UpdateProductResponse updateProductById(UpdateProductRequest request) {
		Product product = new Product();
		product.setId(request.getProductId());
		
		Category category = new Category();
		category.setId(request.getCategoryId());
		
		product.setName(request.getName());
		product.setUnitPrice(request.getUnitPrice());
		product.setUnitsInStock(request.getUnitsInStock());
		product.setCategory(category);
		
		productRepository.save(product);
		
		return new UpdateProductResponse(
				product.getId(), 
				product.getCategory().getId(), 
				product.getUnitsInStock(), 
				product.getName(),
				product.getUnitPrice());
	}

	@Override
	public List<GetAllProductResponse> findByNameToList(GetProductRequest request) {
		
		return productRepository.getByName(request.getProductName())
				.stream().map(p-> new GetAllProductResponse(
						p.getId(), 
						p.getName(), 
						p.getCategory().getName(), 
						p.getUnitsInStock(), 
						p.getUnitPrice()))
				.collect(Collectors.toList());
	}
	
}
