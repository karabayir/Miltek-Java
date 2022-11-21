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
import com.kodlama.io.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.northwind.dataAccess.ProductRepository;
import com.kodlama.io.northwind.entities.Product;
import com.kodlama.io.northwind.exception.ApiRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapperService mapperService;


	@Override
	public List<GetAllProductResponse> getAll() {
		
		
	 return	productRepository.findAll()
		.stream()
		.map(p-> 
				mapperService.forResponse().map(p, GetAllProductResponse.class))
				
		.collect(Collectors.toList());
	}

	@Override
	public CreateProductResponse add(CreateProductRequest request) {
		
		Product product = mapperService.forRequest().map(request, Product.class);
		productRepository.save(product);
		
		return mapperService.forResponse().map(product, CreateProductResponse.class);
				
	}

	@Override
	public GetProductResponse getByName(GetProductRequest request) {
		Product product = productRepository
				.findByName(request.getProductName()).orElseThrow(()-> new ApiRequestException(request.getProductName()+" ismine ait bir product yok xd"));
		
		return mapperService.forResponse().map(product, GetProductResponse.class);
		 
	}

	@Override
	public GetProductResponse getById(GetProductRequest request) {
		Product product = productRepository
				.findById(request.getProductId()).orElseThrow(()-> new ApiRequestException(request.getProductId()+" numaralı id ye ait bir product yok xd"));
		
		return mapperService.forResponse().map(product, GetProductResponse.class);
	}

	@Override
	public void deleteProductById(DeleteProductRequest request) {
		productRepository.deleteById(request.getProductId());
	}

	@Override
	public UpdateProductResponse updateProductById(UpdateProductRequest request) {
		Product product = mapperService.forRequest().map(request, Product.class);
		product.setId(request.getProductId());
		productRepository.save(product);
		
		return mapperService.forResponse().map(product, UpdateProductResponse.class);
	}

	@Override
	public List<GetAllProductResponse> findByNameToList(GetProductRequest request) {
		
		return productRepository.getByName(request.getProductName())
				.stream().
				map(p-> mapperService.forResponse().map(p, GetAllProductResponse.class))
				.collect(Collectors.toList());
	}
	
}
