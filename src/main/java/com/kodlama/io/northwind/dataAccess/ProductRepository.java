package com.kodlama.io.northwind.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.northwind.entities.Product;

public interface ProductRepository  extends JpaRepository<Product,Integer>{

	Product findByName(String name);
	
	List<Product> getByName(String name);
}
