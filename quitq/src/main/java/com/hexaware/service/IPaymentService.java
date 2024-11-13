package com.hexaware.service;
import java.util.List;
import java.util.Optional;

import com.hexaware.entity.Payment;

public interface IPaymentService {

       Payment addPayment(Payment payment);

       Optional<Payment> getPaymentById(Integer paymentId);

       List<Payment> getPaymentsByOrderId(Integer orderId);

       void updatePayment(Integer paymentId, Payment updatedPayment);

       void deletePayment(Integer paymentId);
    
}