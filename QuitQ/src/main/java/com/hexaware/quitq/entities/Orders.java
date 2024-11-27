/* author : Yadnesh Shewale
 * date : 02/11/2024
 * description : orders entity class is created 
 */

package com.hexaware.quitq.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime; // For TIMESTAMP
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;  // Assuming Customer is another entity with a customerId

    @Column(name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime orderDate; // Using LocalDateTime to represent TIMESTAMP

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "ENUM('pending', 'shipped', 'delivered', 'canceled') DEFAULT 'pending'")
    private OrderStatus status = OrderStatus.PENDING; // Default status is 'pending'

    @Column(name = "total_amount", nullable = false)
    @NotNull
    private BigDecimal totalAmount;

    // Constructors
    public Orders() {
        super();
    }

    public Orders(int customerId, LocalDateTime orderDate, OrderStatus status, BigDecimal totalAmount) {
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

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate +
               ", status=" + status + ", totalAmount=" + totalAmount + "]";
    }

    // Enum for Order Status
    public enum OrderStatus {
        PENDING,
        SHIPPED,
        DELIVERED,
        CANCELED
    }
}
