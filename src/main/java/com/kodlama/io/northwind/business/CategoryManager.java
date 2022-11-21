package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.requests.CreateCategoryRequest;
import com.kodlama.io.northwind.business.requests.DeleteCategoryRequest;
import com.kodlama.io.northwind.business.requests.GetCategoryRequest;
import com.kodlama.io.northwind.business.requests.UpdateCategoryRequest;
import com.kodlama.io.northwind.business.responses.CreateCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetCategoryResponse;
import com.kodlama.io.northwind.business.responses.UpdateCategoryResponse;
import com.kodlama.io.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.northwind.dataAccess.CategoryRepository;
import com.kodlama.io.northwind.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final ModelMapperService mapperService;


	@Override
	public List<GetAllCategoryResponse> getAll() {
		return categoryRepository.findAll()
				.stream()
				.map(c ->mapperService.forResponse().map(c, GetAllCategoryResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public CreateCategoryResponse add(CreateCategoryRequest request) {
		Category category = new Category();
		category.setName(request.getName());
		
		categoryRepository.save(category);
		
		return mapperService.forResponse().map(category, CreateCategoryResponse.class);

	}

	@Override
	public GetCategoryResponse getByName(GetCategoryRequest request ) {
		
		Category category = categoryRepository.findByName(request.getCategoryName());
	
		return  mapperService.forResponse().map(category, GetCategoryResponse.class);
		
	}

	@Override
	public GetCategoryResponse getById(GetCategoryRequest request) {
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		return mapperService.forResponse().map(category, GetCategoryResponse.class);
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

	@Override
	public List<UpdateCategoryResponse> findByNameToList(GetCategoryRequest request) {
		return categoryRepository.getByName(request.getCategoryName())
				.stream()
				.map(c-> mapperService.forResponse().map(c, UpdateCategoryResponse.class))
				.collect(Collectors.toList());
	}
}
