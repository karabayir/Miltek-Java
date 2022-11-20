package com.kodlama.io.northwind.business;

import java.util.List;

import com.kodlama.io.northwind.business.requests.CreateCategoryRequest;
import com.kodlama.io.northwind.business.requests.DeleteCategoryRequest;
import com.kodlama.io.northwind.business.requests.GetCategoryRequest;
import com.kodlama.io.northwind.business.requests.UpdateCategoryRequest;
import com.kodlama.io.northwind.business.responses.CreateCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetCategoryResponse;
import com.kodlama.io.northwind.business.responses.UpdateCategoryResponse;

public interface CategoryService {
	
	List<GetAllCategoryResponse> getAll();
	
	GetCategoryResponse getByName(GetCategoryRequest request);
	
	GetCategoryResponse getById(GetCategoryRequest request);
	
	CreateCategoryResponse add(CreateCategoryRequest request);
	
	void deleteCategoryById(DeleteCategoryRequest request);
	
	UpdateCategoryResponse updateCategoryById(UpdateCategoryRequest request);
	
	List<UpdateCategoryResponse> findByNameToList(GetCategoryRequest request);
}
