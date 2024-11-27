package com.hexaware.quitq.service;
/* File: ICustomerService
 * Author: Yash Shrivastava
 * Date Created: 2024-11-12
 * Description: Service Interface for customer          
 */
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
