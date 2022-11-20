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
import com.kodlama.io.northwind.dataAccess.OrderRepository;
import com.kodlama.io.northwind.entities.Employee;
import com.kodlama.io.northwind.entities.Order;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

	private final OrderRepository orderRepository;
	
	@Override
	public List<GetAllOrderResponse> getAll() {
		return orderRepository.findAll()
				.stream()
				.map(o-> new GetAllOrderResponse(
						o.getId(),
						o.getDate(), 
						o.getEmployee().getId()))
				.collect(Collectors.toList());
	}

	/*@Override
	public GetOrderResponse getByName(String name) {
		Order order = orderRepository.findByName(name);
		return new GetOrderResponse(
				order.getDate(), 
				order.getEmployee().getFirstName());
				
	}*/

	@Override
	public GetOrderResponse getById(GetOrderRequest request) {
		Order order =orderRepository.findById(request.getOrderId()).orElseThrow();
		
		
		return new GetOrderResponse(
				order.getId(), 
				order.getDate(), 
				order.getEmployee().getId(),
				order.getEmployee().getFirstName()+" "+order.getEmployee().getLastName()
				);
	}

	@Override
	public CreateOrderResponse add(CreateOrderRequest request) {
		Employee employee = new Employee();	
		employee.setId(request.getEmployeId());
		
		Order order = new Order();
		order.setEmployee(employee);
		
		orderRepository.save(order);
		
		return new CreateOrderResponse(
				order.getId(),
				order.getDate(), 
				order.getEmployee().getId());
	}

	@Override
	public UpdateOrderResponse updateOrderById(UpdateOrderRequest request) {
		Order order = new Order();
		order.setId(request.getOrderId());
		
		Employee employee = new Employee();
		employee.setId(request.getEmployeeId());
		order.setEmployee(employee);
		
		orderRepository.save(order);
		
		return new UpdateOrderResponse(order.getId(),order.getDate(), order.getEmployee().getId());
	}

	@Override
	public void deleteOrderById(DeleteOrderRequest request) {
		orderRepository.deleteById(request.getOrderId());
	}

}
