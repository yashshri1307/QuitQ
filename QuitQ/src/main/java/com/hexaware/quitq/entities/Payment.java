package com.hexaware.quitq.entities;
/* File: Payment Entity
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Payment Entity With Validations
 */

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @NotNull(message = "Order ID cannot be null")
    @Positive(message = "Order ID must be a positive number")
    @Column(nullable = false)
    private int orderId;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be a positive value")
    @Column(nullable = false)
    private double amount;

    @NotNull(message = "Payment method cannot be null")
    @Size(min = 3, max = 50, message = "Payment method must be between 3 and 50 characters")
    @Column(nullable = false)
    private String method;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "^(Pending|Completed|Failed)$", message = "Status must be one of the following: Pending, Completed, Failed")
    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name="date")
    private LocalDate createdAt;

    public Payment() {
        super();
    }

    public Payment(int paymentId,
			@NotNull(message = "Order ID cannot be null") @Positive(message = "Order ID must be a positive number") int orderId,
			@NotNull(message = "Amount cannot be null") @Positive(message = "Amount must be a positive value") double amount,
			@NotNull(message = "Payment method cannot be null") @Size(min = 3, max = 50, message = "Payment method must be between 3 and 50 characters") String method,
			@NotNull(message = "Status cannot be null") @Pattern(regexp = "^(Pending|Completed|Failed)$", message = "Status must be one of the following: Pending, Completed, Failed") String status,
			LocalDate createdAt) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.method = method;
		this.status = status;
		this.createdAt = createdAt;
	}



	public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
                + ", method=" + method + ", status=" + status + ", createdAt=" + createdAt + "]";
    }
}
