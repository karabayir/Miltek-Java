package com.kodlama.io.northwind.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.northwind.business.requests.CreateOrderRequest;
import com.kodlama.io.northwind.business.requests.DeleteOrderRequest;
import com.kodlama.io.northwind.business.requests.GetOrderRequest;
import com.kodlama.io.northwind.business.requests.UpdateOrderRequest;
import com.kodlama.io.northwind.business.responses.CreateOrderResponse;
import com.kodlama.io.northwind.business.responses.GetAllOrderResponse;
import com.kodlama.io.northwind.business.responses.GetOrderResponse;
import com.kodlama.io.northwind.business.responses.UpdateOrderResponse;
import com.kodlama.io.northwind.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.northwind.dataAccess.OrderRepository;
import com.kodlama.io.northwind.entities.Order;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

	private final OrderRepository orderRepository;
	private final ModelMapperService mapperService;
	
	@Override
	public List<GetAllOrderResponse> getAll() {
		return orderRepository.findAll()
				.stream()
				.map(o-> mapperService.forResponse().map(o, GetAllOrderResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetOrderResponse getById(GetOrderRequest request) {
		Order order =orderRepository.findById(request.getOrderId()).orElseThrow();
		
		
		return mapperService.forResponse().map(order, GetOrderResponse.class);
	}

	@Override
	public CreateOrderResponse add(CreateOrderRequest request) {
	
		Order order =mapperService.forRequest().map(request, Order.class);	
		orderRepository.save(order);		
		return mapperService.forResponse().map(order, CreateOrderResponse.class);
	}

	@Override
	public UpdateOrderResponse updateOrderById(UpdateOrderRequest request) {
		Order order = mapperService.forRequest().map(request, Order.class);
		order.setId(request.getOrderId());		
		orderRepository.save(order);	
		return mapperService.forResponse().map(order, UpdateOrderResponse.class);
	}

	@Override
	public void deleteOrderById(DeleteOrderRequest request) {
		orderRepository.deleteById(request.getOrderId());
	}

}
