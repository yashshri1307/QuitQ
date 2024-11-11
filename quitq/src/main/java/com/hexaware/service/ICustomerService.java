package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Customer;

public interface ICustomerService {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerById(int id);

	List<Customer> getAllCustomers();
	
	void updateCustomer(Customer customer);
	
    void deleteCustomer(int id);
	

}
