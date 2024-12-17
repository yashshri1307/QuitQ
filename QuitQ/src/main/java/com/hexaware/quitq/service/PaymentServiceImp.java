package com.hexaware.quitq.service;
/* File: PaymentServiceImp
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Service Implementation for IPaymentService with business logic 
                and using PaymentDTO for data handling
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.dto.PaymentDTO;
import com.hexaware.quitq.entities.Payment;
import com.hexaware.quitq.exception.PaymentNotFoundException;
import com.hexaware.quitq.repository.IPaymentRepository;

@Service
public class PaymentServiceImp implements IPaymentService {

    @Autowired
    IPaymentRepository repo;

    Logger logger = LoggerFactory.getLogger(PaymentServiceImp.class);

    @Override
    public Payment addPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();

        logger.info(paymentDTO + " is being added.");

        payment.setOrderId(paymentDTO.getOrderId());
        payment.setAmount(paymentDTO.getAmount());
        payment.setStatus(paymentDTO.getStatus());
        payment.setMethod(paymentDTO.getMethod());

        Payment addedPayment = repo.save(payment);
        logger.info("Payment added with ID: " + addedPayment.getPaymentId());

        return addedPayment;
    }

    @Override
    public Payment getPayment(int paymentId) {
        return repo.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + paymentId + " not found"));
    }

    @Override
    public List<Payment> getPaymentByOrderId(int orderId) {
        List<Payment> payments = repo.findByOrderId(orderId);
        if (payments.isEmpty()) {
            throw new PaymentNotFoundException("No payments found for Order ID " + orderId);
        }
        return payments;
    }

    @Override
    public Payment getPaymentByPaymentId(int paymentId) {
        return repo.findById(paymentId).orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + paymentId + " not found"));
    }

//    @Override
//    public Payment updatePayment(PaymentDTO paymentDTO) {
//        Payment existingPayment = repo.findById(paymentDTO.getPaymentId())
//                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + paymentDTO.getPaymentId() + " not found"));
//
//        logger.info("Updating payment with ID: " + paymentDTO.getPaymentId());
//
//        existingPayment.setOrderId(paymentDTO.getOrderId());
//        existingPayment.setAmount(paymentDTO.getAmount());
//        existingPayment.setStatus(paymentDTO.getStatus());
//        existingPayment.setDate(paymentDTO.getDate());
//
//        Payment updatedPayment = repo.save(existingPayment);
//        logger.info("Payment updated with ID: " + updatedPayment.getPaymentId());
//
//        return updatedPayment;
//    }
    @Override
    public Payment updatePayment(int paymentId, PaymentDTO paymentDTO) {
        Payment existingPayment = repo.findById(paymentId)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with ID " + paymentId + " not found"));

        logger.info("Updating payment with ID: " + paymentId);

        // Update payment details
      //  existingPayment.setOrderId(paymentDTO.getOrderId());
       // existingPayment.setAmount(paymentDTO.getAmount());
        existingPayment.setStatus(paymentDTO.getStatus());
       // existingPayment.setMethod(paymentDTO.getMethod());

        // Save the updated payment
        Payment updatedPayment = repo.save(existingPayment);
        logger.info("Payment updated with ID: " + updatedPayment.getPaymentId());

        return updatedPayment;
    }
}
