package com.example.order.service;

import java.util.List;
import java.util.Optional;

import com.example.order.entity.OrderEntity;
import com.example.order.model.OrderModel;

public interface OrderService {

	OrderEntity save(OrderModel orderModel);

	Optional<OrderEntity> getOrder(Long id);

	List<OrderEntity> getAllOrders();

}
