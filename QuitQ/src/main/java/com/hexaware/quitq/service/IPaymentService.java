package com.hexaware.quitq.service;
/* File: IPaymentService
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Service Interface for Payment
 */
import com.hexaware.quitq.dto.PaymentDTO;
import com.hexaware.quitq.entities.Payment;

import java.util.List;

public interface IPaymentService {

    public Payment addPayment(PaymentDTO paymentDTO);

    public Payment getPayment(int paymentId);

    public List<Payment> getPaymentByOrderId(int orderId);

    public Payment getPaymentByPaymentId(int paymentId);

    public Payment updatePayment(int id,PaymentDTO paymentDTO);

}
