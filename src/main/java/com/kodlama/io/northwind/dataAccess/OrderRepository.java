package com.kodlama.io.northwind.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.northwind.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	//Order findByName(String name);
}
