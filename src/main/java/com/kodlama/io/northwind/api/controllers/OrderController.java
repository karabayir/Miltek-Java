package com.kodlama.io.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.northwind.business.OrderService;
import com.kodlama.io.northwind.business.requests.CreateOrderRequest;
import com.kodlama.io.northwind.business.requests.DeleteOrderRequest;
import com.kodlama.io.northwind.business.requests.GetOrderRequest;
import com.kodlama.io.northwind.business.requests.UpdateOrderRequest;
import com.kodlama.io.northwind.business.responses.CreateOrderResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.business.responses.GetOrderResponse;
import com.kodlama.io.northwind.business.responses.UpdateOrderResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders/")
@AllArgsConstructor
public class OrderController {

	private final OrderService orderService;
	
	@GetMapping("getAll")
	public List<GetAllOrderResponse> getAll(){
		return orderService.getAll();
	}
	
	/*@GetMapping("getOrderByName")
	GetOrderResponse getByName(@RequestParam String name) {
		return orderService.getByName(name);
	}*/
	
	@GetMapping("getOrderById")
	public GetOrderResponse getById(GetOrderRequest request) {
		return orderService.getById(request);
	}
	
	@PostMapping("addOrder")
	public CreateOrderResponse add(CreateOrderRequest request) {
		return orderService.add(request);
	}
	
	@PutMapping("updateOrder")
	public UpdateOrderResponse updateOrderById(UpdateOrderRequest request) {
		return orderService.updateOrderById(request);
	}
	
	@DeleteMapping("deleteOrder")
	void deleteOrderById(DeleteOrderRequest request) {
		orderService.deleteOrderById(request);
	}
}
