package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.entity.Order;

public class OrderServiceImp implements IOrderService {

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Order> getOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Order> getOrdersByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderStatus(Integer orderId, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		
	}
	

}
