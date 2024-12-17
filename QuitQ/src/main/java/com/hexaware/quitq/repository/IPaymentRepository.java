package com.hexaware.quitq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.quitq.entities.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    // Custom method to find payments by Order ID
    public List<Payment> findByOrderId(int orderId);
    
    // Custom method to find a payment by Payment ID
    public Optional<Payment> findById(Integer paymentId);
    
    // You can add other methods as needed
}
