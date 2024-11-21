package com.hexaware.quitq.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.quitq.dto.CustomerDTO;
import com.hexaware.quitq.entities.Customer;
import com.hexaware.quitq.repository.ICustomerRepository;

@SpringBootTest
@Transactional
@Rollback
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
class CustomerServiceImpTest {

    @Autowired
    private ICustomerService service;

    @Autowired
    private ICustomerRepository repo;

    private CustomerDTO customerDTO;

    @BeforeAll
    void setup() {
  
        customerDTO = new CustomerDTO();
        customerDTO.setName("Yash");
        customerDTO.setEmail("joe@exa.com");
        customerDTO.setPassword("Afh743fd");
        customerDTO.setMobileNumber("1234567890");
        customerDTO.setAddress("jkdf");
    }

    
    @BeforeEach
    void cleanUpBeforeEachTest() {
        repo.findByEmail(customerDTO.getEmail()).ifPresent(customer -> {
            repo.delete(customer); 
        });
    }

    @Test
    void testAddCustomer() {
    	
        Customer c1 = service.addCustomer(customerDTO);
        assertNotNull(c1, "Customer added successfully");
    }

    @Test
    void testGetCustomerById() {

        Customer addedCustomer = service.addCustomer(customerDTO);
 
        Customer fetchedCustomer = service.getCustomerById(addedCustomer.getCustomerId());
        
        assertNotNull(fetchedCustomer, "Customer fetched successfully by ID.");
        assertEquals(addedCustomer.getCustomerId(), fetchedCustomer.getCustomerId(), "Customer IDs match.");
    }

    @Test
    void testGetAllCustomers() {
     
        Iterable<Customer> allCustomers = service.getAllCustomers();
        
        assertNotNull(allCustomers, "Customers fetched successfully.");
    }

    @Test
    void testUpdateCustomer() {

        Customer addedCustomer = service.addCustomer(customerDTO);

        customerDTO.setCustomerId(addedCustomer.getCustomerId()); 
        customerDTO.setName("Updated Name");
        customerDTO.setAddress("Updated Address");
      
        Customer updatedCustomer = service.updateCustomer(customerDTO);
        
        assertNotNull(updatedCustomer, "Customer updated successfully");
       
        assertEquals("Updated Name", updatedCustomer.getName(), "Customer name updated");
        assertEquals("Updated Address", updatedCustomer.getAddress(), "Customer address updated");
    }

    @Test
    void testDeleteCustomerById() {

        Customer addedCustomer = service.addCustomer(customerDTO);

        service.deleteCustomerById(addedCustomer.getCustomerId());

        assertTrue(repo.findById(addedCustomer.getCustomerId()).isEmpty(), "Customer deleted");
    }

    @Test
    void testGetCustomerByEmail() {
  
        service.addCustomer(customerDTO);
    
        Customer fetchedCustomer = service.getCustomerByEmail(customerDTO.getEmail());
        
        assertNotNull(fetchedCustomer, "Customer fetched successfully by email");
        assertEquals(customerDTO.getEmail(), fetchedCustomer.getEmail(), "Customer email match");
    }

    @Test
    void testUpdateAddress() {

        Customer addedCustomer = service.addCustomer(customerDTO);

        String newAddress = "NewAddress";
        
        Customer updatedCustomer = service.updateAddress(addedCustomer.getCustomerId(), newAddress);
        assertNotNull(updatedCustomer, "Customer's addressupdated successfully.");
        assertEquals(newAddress, updatedCustomer.getAddress(), "Customer's addressmatch.");
    }
}
