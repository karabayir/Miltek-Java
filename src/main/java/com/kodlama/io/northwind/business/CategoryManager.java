package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.converter.GetAllCategoryResponseConverter;
import com.kodlama.io.northwind.business.requests.CreateCategoryRequest;
import com.kodlama.io.northwind.business.requests.DeleteCategoryRequest;
import com.kodlama.io.northwind.business.requests.GetCategoryRequest;
import com.kodlama.io.northwind.business.requests.UpdateCategoryRequest;
import com.kodlama.io.northwind.business.responses.CreateCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllProductResponse;
import com.kodlama.io.northwind.business.responses.GetCategoryResponse;
import com.kodlama.io.northwind.business.responses.UpdateCategoryResponse;
import com.kodlama.io.northwind.dataAccess.CategoryRepository;
import com.kodlama.io.northwind.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final GetAllCategoryResponseConverter converter;


	@Override
	public List<GetAllCategoryResponse> getAll() {
		return categoryRepository.findAll()
				.stream()
				.map(c -> converter.convert(c))
				.collect(Collectors.toList());
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest request) {
		Category category = new Category();
		category.setName(request.getName());
		
		categoryRepository.save(category);
		
		return new CreateCategoryResponse(category.getId(), category.getName());
	}

	@Override
	public GetCategoryResponse getByName(GetCategoryRequest request ) {
		
		Category category = categoryRepository.findByName(request.getCategoryName());
		
		List<GetAllProductResponse> products = projectToProjectResponseInCategory(category);
				
		return new GetCategoryResponse(
				category.getId(), 
				category.getName(), 
				products);
	}

	@Override
	public GetCategoryResponse getById(GetCategoryRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		
		List<GetAllProductResponse> products = projectToProjectResponseInCategory(category);
		
		return new GetCategoryResponse(
				category.getId(), 
				category.getName(), 
				products);
	}

	@Override
	public void deleteCategoryById(DeleteCategoryRequest request) {
		categoryRepository.deleteById(request.getCategoryId());
	}

	@Override
	public UpdateCategoryResponse updateCategoryById(UpdateCategoryRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		category.setName(request.getName());
		
		categoryRepository.save(category);
		
		return new UpdateCategoryResponse(category.getId(), category.getName());
	}
	
	private List<GetAllProductResponse> projectToProjectResponseInCategory(Category category){
		
		return category.getProducts()
		.stream()
		.map(p-> new GetAllProductResponse(
				p.getId(), 
				p.getName(), 
				p.getCategory().getName(), 
				p.getUnitsInStock(), 
				p.getUnitPrice()))
		.collect(Collectors.toList());
	}

	@Override
	public List<UpdateCategoryResponse> findByNameToList(GetCategoryRequest request) {
		return categoryRepository.getByName(request.getCategoryName())
				.stream()
				.map(c-> new UpdateCategoryResponse(
						c.getId(), 
						c.getName()))
				.collect(Collectors.toList());
	}
}
