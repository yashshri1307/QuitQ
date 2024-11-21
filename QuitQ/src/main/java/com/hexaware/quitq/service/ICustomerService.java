package com.hexaware.quitq.service;

import java.util.List;

import com.hexaware.quitq.dto.CustomerDTO;
import com.hexaware.quitq.entities.Customer;

public interface ICustomerService {
	
	public Customer addCustomer(CustomerDTO customerDTO);
	
	public Customer getCustomerById(Integer id);

	public List<Customer> getAllCustomers();
	
	public Customer updateCustomer(CustomerDTO customerDTO);
	
    public String deleteCustomerById(Integer id);
    
    public Customer getCustomerByEmail(String email);
    
    public Customer updateAddress(Integer id, String address);

}
