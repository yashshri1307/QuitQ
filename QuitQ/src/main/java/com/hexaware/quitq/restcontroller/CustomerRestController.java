package com.hexaware.quitq.restcontroller;
/* File: CustomerRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-11-14
 * Description: Customer Controller will have api mapping for customer functionality        
                will take Data using CustomerDTO
                and will transfer to service layer
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.hexaware.quitq.dto.CustomerDTO;
import com.hexaware.quitq.entities.Customer;
import com.hexaware.quitq.exception.CustomerNotFoundException;
import com.hexaware.quitq.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	
	@Autowired
	ICustomerService service;
	
	Logger logger=LoggerFactory.getLogger(CustomerRestController.class);
	
	@PostMapping("/addcustomer")
	public Customer addcustomer(@RequestBody CustomerDTO customerDTO)
	{
		logger.info("Customer Rest Controller executed");
		
		return service.addCustomer(customerDTO);
	}
	
	@GetMapping("/getcustomer/{id}")
	public Customer getcustomerById(@PathVariable Integer id)
	{
		return service.getCustomerById(id);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public String handleException(CustomerNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@GetMapping("/getall")
	public List<Customer> getAll()
	{
		return service.getAllCustomers();
	}

	@PutMapping("/updatecustomer")
	public Customer updatecustomer(@RequestBody CustomerDTO customerDTO)
	{
		return service.updateCustomer(customerDTO);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public String deletebyid(@PathVariable Integer id)
	{
		return service.deleteCustomerById(id);
	}
	
	@GetMapping("/getcustomerByEmail/{email}")
	public Customer getcustomerbyEmail(@PathVariable String email)
	{
		return service.getCustomerByEmail(email);
	}
	
	@PutMapping("/updateaddress/{id}")
	public Customer updateaddressbyId(@PathVariable Integer id,@RequestBody String address)
	{
		return service.updateAddress(id, address);
	}
}
