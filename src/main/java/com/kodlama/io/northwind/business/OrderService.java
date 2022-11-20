package com.kodlama.io.northwind.business;

import java.util.List;

import com.kodlama.io.northwind.business.requests.CreateOrderRequest;
import com.kodlama.io.northwind.business.requests.DeleteOrderRequest;
import com.kodlama.io.northwind.business.requests.GetOrderRequest;
import com.kodlama.io.northwind.business.requests.UpdateOrderRequest;
import com.kodlama.io.northwind.business.responses.CreateOrderResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.business.responses.GetOrderResponse;
import com.kodlama.io.northwind.business.responses.UpdateOrderResponse;

public interface OrderService {

	List<GetAllOrderResponse> getAll();
	
	/*GetOrderResponse getByName(String name);*/
	
	GetOrderResponse getById(GetOrderRequest request);
	
	CreateOrderResponse add(CreateOrderRequest request);
	
	UpdateOrderResponse updateOrderById(UpdateOrderRequest request);
	
	void deleteOrderById(DeleteOrderRequest request);
}
