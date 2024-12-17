/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : Orders entity class with necessary fields and mapping.
 */

package com.hexaware.quitq.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('pending', 'shipped', 'delivered', 'canceled') DEFAULT 'pending'")
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "total_amount", nullable = false)
    @NotNull
    private BigDecimal totalAmount;

    // Constructors, Getters, and Setters
    public Orders() {}

    public Orders(int customerId, LocalDateTime orderDate, OrderStatus status, BigDecimal totalAmount) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public enum OrderStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        CANCELED
    }
}
