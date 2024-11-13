package com.hexaware.service;
import java.util.List;
import java.util.Optional;
import com.hexaware.entity.Order;

public interface IOrderService {
    
       Order addOrder(Order order);

       Optional<Order> getOrderById(Integer orderId);
   
       List<Order> getOrdersByCustomerId(Integer customerId);

       void updateOrderStatus(Integer orderId, String status);

       void deleteOrder(Integer orderId);
}