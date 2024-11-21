package com.hexaware.quitq.services;


import com.hexaware.quitq.entities.Inventory;

import java.util.List;

public interface IInventoryService {

    // Create a new inventory record
    public Inventory addInventory(Inventory inventory);

    // Update an existing inventory record
    public Inventory updateInventory(Inventory inventory);

    // Get inventory by ID
    public Inventory getInventoryById(int inventoryId);

    // Delete inventory by ID
    public String deleteInventoryById(int inventoryId);

    // Get all inventory records
    public List<Inventory> getAllInventory();

    // Get inventory by product ID
    public List<Inventory> getByProductId(int productId);

    // Get inventory with stock greater than a specific value
    public List<Inventory> getByStockGreaterThan(int stockQuantity);

    // Get inventory by status (active, out-of-stock, etc.)
    public List<Inventory> getByStatus(String status);

    // Delete inventory by product ID
    public int deleteByProductId(int productId);
}
