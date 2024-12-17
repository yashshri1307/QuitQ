/* File: orders DTO
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-11
 * Description: orders DTO With Validations 
 *              For Data Transfer between Layers             
 */

package com.hexaware.quitq.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrdersDTO {

    private int orderId;
    private int customerId;
    private LocalDateTime orderDate;
    private String status;
    private BigDecimal totalAmount;

    // Default constructor
    public OrdersDTO() {
    }

    // Constructor for creating a DTO from an entity
    public OrdersDTO(int orderId, int customerId, LocalDateTime orderDate, String status, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Convert the OrderDTO to a string
    @Override
    public String toString() {
        return "OrderDTO [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate +
               ", status=" + status + ", totalAmount=" + totalAmount + "]";
    }

    // Method to convert the Entity to DTO (useful in a Service class)
    public static OrdersDTO fromEntity(com.hexaware.quitq.entities.Orders order) {
        return new OrdersDTO(
            order.getOrderId(),
            order.getCustomerId(),
            order.getOrderDate(),
            order.getStatus().name(), // Convert Enum to String
            order.getTotalAmount()
        );
    }

    // Method to convert DTO to Entity (useful if you need to save the DTO as an entity)
    public com.hexaware.quitq.entities.Orders toEntity() {
        com.hexaware.quitq.entities.Orders order = new com.hexaware.quitq.entities.Orders();
        order.setOrderId(this.orderId);
        order.setCustomerId(this.customerId);
        order.setOrderDate(this.orderDate);
        order.setStatus(com.hexaware.quitq.entities.Orders.OrderStatus.valueOf(this.status));
        order.setTotalAmount(this.totalAmount);
        return order;
    }
}
