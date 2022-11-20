package com.kodlama.io.northwind.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.northwind.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByName(String name);
	
	List<Category> getByName(String name);
}
