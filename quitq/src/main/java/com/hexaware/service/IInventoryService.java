package com.hexaware.service;

import com.hexaware.entity.Inventory;
import java.util.List;

public interface IInventoryService {
    void addInventory(Inventory inventory);

    Inventory getInventoryById(int id);  // Ensure this method is declared in the interface

    List<Inventory> getAllInventories();

    void updateInventory(Inventory inventory);

    void deleteInventory(int id);
}
