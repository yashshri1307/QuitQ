package com.hexaware.quitq.restcontroller;
/* File: PaymentRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-12-18
 * Description: Payment Controller will have API mappings for payment functionality        
                Will take data and transfer it to the service layer
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.dto.PaymentDTO;
import com.hexaware.quitq.entities.Payment;
import com.hexaware.quitq.exception.PaymentNotFoundException;
import com.hexaware.quitq.service.IPaymentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/payment")
public class PaymentRestController {

    @Autowired
    private IPaymentService service;

    Logger logger = LoggerFactory.getLogger(PaymentRestController.class);

    @PostMapping("/add")
    public Payment addPayment(@RequestBody PaymentDTO paymentDTO) {
        logger.info("Payment Rest Controller executed");
        return service.addPayment(paymentDTO);
    }

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable Integer id) {
        return service.getPaymentByPaymentId(id);
    }

    @GetMapping("/getbyorder/{orderId}")
    public List<Payment> getPaymentByOrderId(@PathVariable Integer orderId) {
        return service.getPaymentByOrderId(orderId);
    }

    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Integer id, @RequestBody PaymentDTO paymentDTO) {
        return service.updatePayment(id, paymentDTO);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public String handleException(PaymentNotFoundException ex) {
        return ex.getMessage();
    }
}
