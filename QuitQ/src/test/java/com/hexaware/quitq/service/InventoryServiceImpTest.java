/* author : Yadnesh Shewale
 * date : 23/11/2024
 * 
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.Inventory;
import com.hexaware.quitq.repository.IInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

// import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  
@Transactional 
public class InventoryServiceImpTest {

    @Autowired
    private IInventoryRepository inventoryRepository;

    @Autowired
    private InventoryServiceImp inventoryService;  // The actual service we are testing

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventoryRepository.deleteAll();  // Clear the repository before each test to ensure a clean state
        inventory = new Inventory(1, 101, 50, 5000.0, "active", null);
        inventoryRepository.save(inventory);  // Save a default inventory entry before each test
    }

    @Test
    void testAddInventory() {
        Inventory newInventory = new Inventory(2, 102, 100, 10000.0, "active", null);
        Inventory createdInventory = inventoryService.addInventory(newInventory);
        
        assertNotNull(createdInventory);
        assertEquals(2, createdInventory.getInventoryId());
        assertEquals("active", createdInventory.getStatus());
    }

    @Test
    void testUpdateInventory() {
        inventory.setStockQuantity(60);  // Updating stock quantity
        Inventory updatedInventory = inventoryService.updateInventory(inventory);

        assertNotNull(updatedInventory);
        assertEquals(60, updatedInventory.getStockQuantity());
    }

    @Test
    void testGetInventoryById() {
        Optional<Inventory> foundInventory = inventoryRepository.findById(1);
        assertTrue(foundInventory.isPresent());
        assertEquals(1, foundInventory.get().getInventoryId());
    }

    @Test
    void testGetInventoryById_NotFound() {
        Optional<Inventory> foundInventory = inventoryRepository.findById(99);
        assertFalse(foundInventory.isPresent());
    }

    @Test
    void testGetAllInventory() {
        List<Inventory> inventories = inventoryService.getAllInventory();

        assertNotNull(inventories);
        assertTrue(inventories.size() > 0);
        assertEquals(1, inventories.get(0).getInventoryId());
    }

    @Test
    void testGetByProductId() {
        List<Inventory> inventories = inventoryService.getByProductId(101);

        assertNotNull(inventories);
        assertTrue(inventories.size() > 0);
        assertEquals(101, inventories.get(0).getProductId());
    }

    @Test
    void testDeleteInventoryById() {
        String result = inventoryService.deleteInventoryById(1);
        
        assertEquals("Inventory with ID 1 deleted successfully.", result);

        Optional<Inventory> deletedInventory = inventoryRepository.findById(1);
        assertFalse(deletedInventory.isPresent());
    }

    @Test
    void testDeleteInventoryById_NotFound() {
        String result = inventoryService.deleteInventoryById(99);
        
        assertEquals("Inventory with ID 99 not found.", result);
    }

    @Test
    void testGetByStockGreaterThan() {
        List<Inventory> inventories = inventoryService.getByStockGreaterThan(30);

        assertNotNull(inventories);
        assertTrue(inventories.size() > 0);
        assertTrue(inventories.get(0).getStockQuantity() > 30);
    }

    @Test
    void testDeleteByProductId() {
        int deletedCount = inventoryService.deleteByProductId(101);
        
        assertEquals(1, deletedCount);
        
        // Verify the product has been deleted
        List<Inventory> inventories = inventoryRepository.findByProductId(101);
        assertTrue(inventories.isEmpty());
    }
}
