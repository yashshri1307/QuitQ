package com.hexaware.quitq.service;
/* File: CustomerServiceImp
 * Author: Yash Shrivastava
 * Date Created: 2024-11-12
 * Description: Service Implementation for serviceInterface for customer          
                Will Contain business logic and 
                will take Data using CustomerDTO
 */ 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.dto.CustomerDTO;
import com.hexaware.quitq.entities.Customer;
import com.hexaware.quitq.entities.UserInfo;
import com.hexaware.quitq.exception.CustomerAlreadyExistsException;
import com.hexaware.quitq.exception.CustomerNotFoundException;
import com.hexaware.quitq.repository.ICustomerRepository;
import com.hexaware.quitq.repository.UserInfoRepository;

@Service
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository repo;
	
	@Autowired
	UserInfoRepository userrepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	Logger logger=LoggerFactory.getLogger(CustomerServiceImp.class);
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
	
		Customer customer=new Customer();
		
		if((repo.findByEmail(customerDTO.getEmail())).isPresent())
		{
			logger.warn("Already Exist");
			
			throw new CustomerAlreadyExistsException("Customer with email " + customerDTO.getEmail() + " already exists.");
		}
		
		logger.info(customerDTO + " is Added from Add Service");
		
		customer.setName(customerDTO.getName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
		customer.setMobileNumber(customerDTO.getMobileNumber());
		customer.setAddress(customerDTO.getAddress());
		
			Customer added= repo.save(customer);
			
			UserInfo userinfo=new UserInfo();
			
			userinfo.setId(added.getCustomerId());
			userinfo.setName(added.getName());
			userinfo.setEmail(added.getEmail());
			userinfo.setPassword(added.getPassword());
			userinfo.setRoles("CUSTOMER");
			
			userrepo.save(userinfo);
			
			return added;
			
	}

	@Override
	public Customer getCustomerById(Integer id) {
	
		return repo.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + id + " not found"));
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
	
		if(!(repo.findByEmail(customerDTO.getEmail())).isPresent())
		{
			throw new CustomerNotFoundException("Customer with email " + customerDTO.getEmail() + " Not Found.");
		}
		
		Customer customer=new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());	
		customer.setName(customerDTO.getName());		
		customer.setEmail(customerDTO.getEmail());		
		customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));	
		customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setAddress(customerDTO.getAddress());
		
			return repo.save(customer);
	}

	@Override
	public String deleteCustomerById(Integer id) {
		
		if(!(repo.findById(id)).isPresent())
       {
	     throw new CustomerNotFoundException("Customer with ID " + id + " not found");
       }
		repo.deleteById(id);
		
		return "Record Deleted";
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		
		return repo.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException("Customer with email " + email + " not found."));
	}

	@Override
	public Customer updateAddress(Integer id, String address) {
		
		Customer customer=repo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with ID " + id + " not found"));
		
		customer.setAddress(address);
		
		return repo.save(customer);
	}
}
