package com.kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.northwind.business.CategoryService;
import com.kodlama.io.northwind.business.requests.CreateCategoryRequest;
import com.kodlama.io.northwind.business.requests.DeleteCategoryRequest;
import com.kodlama.io.northwind.business.requests.GetCategoryRequest;
import com.kodlama.io.northwind.business.requests.UpdateCategoryRequest;
import com.kodlama.io.northwind.business.responses.CreateCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetAllCategoryResponse;
import com.kodlama.io.northwind.business.responses.GetCategoryResponse;
import com.kodlama.io.northwind.business.responses.UpdateCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories/")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;
	
	@GetMapping("getAll")
	public List<GetAllCategoryResponse> getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("getCategoryByName")
	public GetCategoryResponse getByName(GetCategoryRequest request) {
		return categoryService.getByName(request);
	}
	
	@GetMapping("getCategoryById")
	public GetCategoryResponse getById(GetCategoryRequest request) {
		return categoryService.getById(request);
	}
	
	@PostMapping("addCategory")
	public CreateCategoryResponse add(CreateCategoryRequest request) {
		return categoryService.add(request);
	}
	
	@PutMapping("updateCategory")
	public UpdateCategoryResponse updateCategoryById(UpdateCategoryRequest request) {
		return categoryService.updateCategoryById(request);
	}
	
	@DeleteMapping("deleteCategory")
	public void deleteCategoryById(DeleteCategoryRequest request) {
		 categoryService.deleteCategoryById(request);
	}
	
	@GetMapping("getCategoryListByName")
	public List<UpdateCategoryResponse> findByNameToList(GetCategoryRequest request){
		return categoryService.findByNameToList(request);
	}
}
