package com.hexaware.quitq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.Customer;
import com.hexaware.quitq.exception.CustomerAlreadyExistsException;
import com.hexaware.quitq.exception.CustomerNotFoundException;
import com.hexaware.quitq.repository.ICustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService{

	@Autowired
	ICustomerRepository repo;
	
	@Override
	public Customer addCustomer(Customer customer) {
	
		if((repo.findByEmail(customer.getEmail())).isPresent())
		{
			throw new CustomerAlreadyExistsException("Customer with email " + customer.getEmail() + " already exists.");
		}
			return repo.save(customer);
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
	public Customer updateCustomer(Customer customer) {
	
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
