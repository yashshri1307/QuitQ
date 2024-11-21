package com.hexaware.quitq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.quitq.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

     public Optional<Customer> findByEmail(String email);
	
}
