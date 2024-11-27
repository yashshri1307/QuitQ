/* author : Yadnesh Shewale
 * date : 09/11/2024
 * description : Orders Service interface methods implementation is done here 
 */

package com.hexaware.quitq.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.Orders;
import com.hexaware.quitq.repository.IOrdersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrdersServiceImp implements IOrdersService {

    @Autowired
    private IOrdersRepository ordersRepo;

    Logger logger = LoggerFactory.getLogger(OrdersServiceImp.class);

    @Override
    public Orders addOrder(Orders order) {
        logger.info("addOrder service is called");

        // Validate the order before adding
        if (validateOrder(order)) {
            return ordersRepo.save(order);
        } else {
            logger.error("Failed to add Order: Validation failed");
            throw new IllegalArgumentException("Invalid Order data");
        }
    }

    @Override
    public Orders updateOrder(Orders order) {
        logger.info("updateOrder service is called");

        // Validate the order before updating
        if (validateOrder(order)) {
            return ordersRepo.save(order);
        } else {
            logger.error("Failed to update Order: Validation failed");
            throw new IllegalArgumentException("Invalid Order data");
        }
    }

    @Override
    public Orders getOrderById(int orderId) {
        logger.info("getOrderById service is called for orderId: " + orderId);
        return ordersRepo.findById(orderId).orElse(null);
    }

    @Override
    public String deleteOrderById(int orderId) {
        logger.warn("deleteOrderById service is called for orderId: " + orderId);
        ordersRepo.deleteById(orderId);
        logger.debug("Order record deleted for orderId: " + orderId);
        return "Order Record Deleted";
    }

    @Override
    public List<Orders> getAllOrders() {
        logger.info("getAllOrders service is called");
        return ordersRepo.findAll();
    }

    @Override
    public List<Orders> getByStatus(String status) {
        logger.info("getByStatus service is called for status: " + status);
        return ordersRepo.findByStatus(status);
    }

    @Override
    public List<Orders> getByCustomerId(int customerId) {
        logger.info("getByCustomerId service is called for customerId: " + customerId);
        return ordersRepo.findByCustomerId(customerId);
    }

    @Override
    public List<Orders> getByTotalAmountGreaterThan(Double amount) {
        logger.info("getByTotalAmountGreaterThan service is called for amount: " + amount);
        return ordersRepo.findByTotalAmountGreaterThan(new BigDecimal(amount));
    }

    @Override
    public List<Orders> getOrdersByCustomerId(int customerId) {
        logger.info("getOrdersByCustomerId service is called for customerId: " + customerId);
        return ordersRepo.findByCustomerId(customerId);
    }

    @Override
    public List<Orders> getOrdersByStatus(String status) {
        logger.info("getOrdersByStatus service is called for status: " + status);
        return ordersRepo.findByStatus(status);
    }

    @Override
    public List<Orders> getOrdersByDateRange(String startDate, String endDate) {
        logger.info("getOrdersByDateRange service is called for startDate: " + startDate + " to endDate: " + endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ordersRepo.findByOrderDateBetween(start, end);
    }

    @Override
    public BigDecimal getOrderTotalAmount(int orderId) {
        logger.info("getOrderTotalAmount service is called for orderId: " + orderId);
        Orders order = ordersRepo.findById(orderId).orElse(null);
        if (order != null) {
            return order.getTotalAmount();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public String deleteOrdersByCustomerId(int customerId) {
        logger.warn("deleteOrdersByCustomerId service is called for customerId: " + customerId);
        List<Orders> orders = ordersRepo.findByCustomerId(customerId);
        if (orders != null && !orders.isEmpty()) {
            ordersRepo.deleteAll(orders);
            logger.debug("Deleted orders for customerId: " + customerId);
            return "Orders Deleted for CustomerId: " + customerId;
        }
        return "No Orders found for CustomerId: " + customerId;
    }

    @Override
    public String deleteOrdersByStatus(String status) {
        logger.warn("deleteOrdersByStatus service is called for status: " + status);
        List<Orders> orders = ordersRepo.findByStatus(status);
        if (orders != null && !orders.isEmpty()) {
            ordersRepo.deleteAll(orders);
            logger.debug("Deleted orders for status: " + status);
            return "Orders Deleted for Status: " + status;
        }
        return "No Orders found for Status: " + status;
    }

    @Override
    public String deleteOrdersByDateRange(String startDate, String endDate) {
        logger.warn("deleteOrdersByDateRange service is called for startDate: " + startDate + " to endDate: " + endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        List<Orders> orders = ordersRepo.findByOrderDateBetween(start, end);
        if (orders != null && !orders.isEmpty()) {
            ordersRepo.deleteAll(orders);
            logger.debug("Deleted orders for date range: " + startDate + " to " + endDate);
            return "Orders Deleted for Date Range: " + startDate + " to " + endDate;
        }
        return "No Orders found for Date Range: " + startDate + " to " + endDate;
    }

   /* @Override
    public Orders updateOrderStatus(int orderId, String status) {
        logger.info("updateOrderStatus service is called for orderId: " + orderId + " with status: " + status);
        Orders order = ordersRepo.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);  // This is the part where we set the status
            return ordersRepo.save(order);
        } else {
            logger.error("Order not found for orderId: " + orderId);
            throw new IllegalArgumentException("Order not found for orderId: " + orderId);
        }
    } */

    // Input validation for Order
    public static boolean validateOrder(Orders order) {
        boolean isValid = false;

        if (order != null && order.getCustomerId() > 0 && order.getTotalAmount() != null &&
            order.getTotalAmount().compareTo(new BigDecimal("0")) > 0) {
            isValid = true;
        }

        return isValid;
    }
}
