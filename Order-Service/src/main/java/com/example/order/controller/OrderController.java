package com.example.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.OrderEntity;
import com.example.order.model.OrderModel;
import com.example.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public String index() {
		return "Welcome order";

	}

	@PostMapping("/addorder")
	public OrderEntity save(@RequestBody OrderModel orderModel) {
		return orderService.save(orderModel);

	}
	
	@GetMapping("/getbyid/{id}")
	public Optional<OrderEntity> getOrder(@PathVariable Long id) {
		return orderService.getOrder(id);
		
	}
	
	@GetMapping("/getallorders")
	public List<OrderEntity> getOrderEntities(){
		return orderService.getAllOrders();
		
		
	}
}
