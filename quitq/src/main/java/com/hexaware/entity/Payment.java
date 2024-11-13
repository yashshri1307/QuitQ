package com.hexaware.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class Payment {

       private Integer paymentId; 
       private Integer orderId;
       private LocalDateTime paymentDate;
       private BigDecimal amount;  
       private Method method;
       private Status status;

    
    public enum Method {
        CREDIT_CARD, DEBIT_CARD, UPI, NET_BANKING, COD
    }

  
    public enum Status {
        COMPLETED, PENDING, FAILED
    }

 
    public Payment() {
        super();
    }

        public Payment(Integer paymentId, Integer orderId, LocalDateTime paymentDate, BigDecimal amount, Method method, Status status) {
        super();
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }


    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                '}';
    }

}
