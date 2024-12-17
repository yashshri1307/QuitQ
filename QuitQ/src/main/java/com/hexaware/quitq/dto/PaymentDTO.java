package com.hexaware.quitq.dto;
/* File: Payment DTO
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Payment DTO with Validations
 *              For Data Transfer between Layers
 */

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class PaymentDTO {

    private int paymentId; // Auto-generated

    @NotNull(message = "Order ID cannot be null")
    @Positive(message = "Order ID must be a positive number")
    private int orderId;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be a positive value")
    private double amount;

    @NotNull(message = "Payment method cannot be null")
    @Size(min = 3, max = 50, message = "Payment method must be between 3 and 50 characters")
    private String method;

    @NotNull(message = "Status cannot be null")
    @Pattern(regexp = "^(Pending|Completed|Failed)$", message = "Status must be one of the following: Pending, Completed, Failed")
    private String status;

    public PaymentDTO() {
        super();
    }
    
    public PaymentDTO(int paymentId,
			@NotNull(message = "Order ID cannot be null") @Positive(message = "Order ID must be a positive number") int orderId,
			@NotNull(message = "Amount cannot be null") @Positive(message = "Amount must be a positive value") double amount,
			@NotNull(message = "Payment method cannot be null") @Size(min = 3, max = 50, message = "Payment method must be between 3 and 50 characters") String method,
			@NotNull(message = "Status cannot be null") @Pattern(regexp = "^(Pending|Completed|Failed)$", message = "Status must be one of the following: Pending, Completed, Failed") String status) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.method = method;
		this.status = status;
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

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount + ", method="
				+ method + ", status=" + status + "]";
	}

   
}
