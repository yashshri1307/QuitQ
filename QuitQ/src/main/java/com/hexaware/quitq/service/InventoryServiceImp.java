/* author : Yadnesh Shewale
 * date : 09/11/2024
 * description : Implementation of IInventoryService.
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.Inventory;
import com.hexaware.quitq.repository.IInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class InventoryServiceImp implements IInventoryService {

    @Autowired
    private IInventoryRepository repository;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        Optional<Inventory> existingInventory = repository.findById(inventory.getInventoryId());

        if (existingInventory.isEmpty()) {
            throw new RuntimeException("Inventory not found for ID: " + inventory.getInventoryId());
        }

        // Update fields as needed
        Inventory updatedInventory = existingInventory.get();
        updatedInventory.setProductId(inventory.getProductId());
        updatedInventory.setStockQuantity(inventory.getStockQuantity());
        updatedInventory.setStockValue(inventory.getStockValue());
        updatedInventory.setStatus(inventory.getStatus());

        return repository.save(updatedInventory);
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return repository.findById(inventoryId).orElse(null);
    }

    @Override
    public String deleteInventoryById(int inventoryId) {
        repository.deleteById(inventoryId);
        return "Inventory deleted successfully!";
    }

    @Override
    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }

    @Override
    public List<Inventory> getByProductId(int productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<Inventory> getByStockGreaterThan(int stockQuantity) {
        return repository.findByStockQuantityGreaterThan(stockQuantity);
    }

    @Override
    public List<Inventory> getByStatus(String status) {
        return repository.findByStatus(status);
    }
}
