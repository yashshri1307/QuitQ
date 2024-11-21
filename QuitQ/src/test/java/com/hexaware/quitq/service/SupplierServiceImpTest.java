package com.hexaware.quitq.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.quitq.dto.SupplierDTO;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.repository.ISupplierRepository;

@SpringBootTest
@Transactional
@Rollback
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SupplierServiceImpTest {

    @Autowired
    private ISupplierService service;

    @Autowired
    private ISupplierRepository repo;

    private SupplierDTO supplierDTO;

    @BeforeAll
    void setup() {

        supplierDTO = new SupplierDTO();
        supplierDTO.setName("SJjk");
        supplierDTO.setEmail("sup@jfd.com");
        supplierDTO.setPassword("Asup1243");
        supplierDTO.setMobileNumber("8966007246");
        supplierDTO.setCompanyName("sup");
        supplierDTO.setAddress("add");
    }

    @BeforeEach
    void cleanUpBeforeEachTest() {
    	
        repo.findByEmail(supplierDTO.getEmail()).ifPresent(supplier -> {
            repo.delete(supplier);
        });
    }

    @Test
    void testAddSupplier() {

        Supplier addedSupplier = service.addSupplier(supplierDTO);
        assertNotNull(addedSupplier, "Supplier added successfully");
    }

    @Test
    void testGetSupplierById() {

        Supplier addedSupplier = service.addSupplier(supplierDTO);

        Supplier fetchedSupplier = service.getSupplierById(addedSupplier.getSupplierId());

       assertNotNull(fetchedSupplier, "Supplier fetched successfully by ID.");
        
        assertEquals(addedSupplier.getSupplierId(), fetchedSupplier.getSupplierId(), "Supplier ID match");
    }

    @Test
    void testGetAllSuppliers() {

        Iterable<Supplier> allSuppliers = service.getAllSuppliers();
        
        assertNotNull(allSuppliers, "Suppliers fetched successfully.");
    }

    @Test
    void testUpdateSupplier() {

        Supplier addedSupplier = service.addSupplier(supplierDTO);
  
        supplierDTO.setSupplierId(addedSupplier.getSupplierId());
        supplierDTO.setName("updatedsupplier");
        supplierDTO.setCompanyName("UpdatedCompany");
       
        Supplier updatedSupplier = service.updateSupplier(supplierDTO);

        assertNotNull(updatedSupplier, "Supplier updated successfully.");
        
        assertEquals("updatedsupplier", updatedSupplier.getName(), "Supplier name updated");
        assertEquals("UpdatedCompany", updatedSupplier.getCompanyName(), "Supplier company name updated");
    }

    @Test
    void testDeleteSupplierById() {

        Supplier addedSupplier = service.addSupplier(supplierDTO);

        service.deleteSupplierById(addedSupplier.getSupplierId());

        assertTrue(repo.findById(addedSupplier.getSupplierId()).isEmpty(), "Supplier deleted.");
    }

    @Test
    void testGetSupplierByEmail() {

        service.addSupplier(supplierDTO);

        Supplier fetchedSupplier = service.getSupplierByEmail(supplierDTO.getEmail());
       
        assertNotNull(fetchedSupplier, "Supplier fetched successfully by email.");
        
        assertEquals(supplierDTO.getEmail(), fetchedSupplier.getEmail(), "Supplier email match.");
    }
}
