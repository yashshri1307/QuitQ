/* author : Yadnesh Shewale
 * date : 09/11/2024
 * 
 */

package com.hexaware.quitq.service;

import java.util.List;

import com.hexaware.quitq.entities.Inventory;
import com.hexaware.quitq.repository.IInventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventoryServiceImp implements IInventoryService {

    @Autowired
    IInventoryRepository repo;

    @Override
    public Inventory addInventory(Inventory inventory) {
        return repo.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return repo.save(inventory);
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return repo.findById(inventoryId).orElse(null);
    }

    @Override
    public String deleteInventoryById(int inventoryId) {
        repo.deleteById(inventoryId);
        return "Inventory Record Deleted";
    }

    @Override
    public List<Inventory> getAllInventory() {
        return repo.findAll();
    }

    @Override
    public List<Inventory> getByProductId(int productId) {
        return repo.findByProductId(productId);
    }

    @Override
    public List<Inventory> getByStockGreaterThan(int stockQuantity) {
        return repo.findByStockQuantityGreaterThan(stockQuantity);
    }

    @Override
    public List<Inventory> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    @Override
    public int deleteByProductId(int productId) {
        return repo.deleteByProductId(productId);
    }
}
