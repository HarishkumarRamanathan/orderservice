package com.example.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.dao.OrderRepostiory;
import com.example.order.entity.OrderEntity;
import com.example.order.model.OrderModel;
import com.example.order.model.PaymentModel;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepostiory orderRepostiory;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private EurekaClient eurekaClient;

	@Override
	public OrderEntity save(OrderModel orderModel) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderName(orderModel.getOrderName());
		orderEntity.setQty(orderModel.getQty());
		orderEntity.setAmount(orderModel.getAmount());

		orderRepostiory.save(orderEntity);

		PaymentModel paymentModel = new PaymentModel();
		paymentModel.setOrderId(orderEntity.getOrderId());
		paymentModel.setAmount(orderEntity.getAmount());

		/*
		 * InstanceInfo info= eurekaClient.getNextServerFromEureka("PAYMENT-SERVICE",
		 * false); String url = info.getHomePageUrl();
		 */
		// use loadbanced in RestTemplate to communicate the payment service
		restTemplate.postForEntity("http://PAYMENT-SERVICE/payment/dopayment", paymentModel, String.class);
		return null;
	}

	@Override
	public Optional<OrderEntity> getOrder(Long id) {
		// TODO Auto-generated method stub

		return orderRepostiory.findById(id);
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepostiory.findAll();
	}

}
