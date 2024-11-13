package com.hexaware.service;

import java.util.List;
import com.hexaware.entity.Inventory;

public class InventoryServiceImp implements IInventoryService {

    @Override
    public void addInventory(Inventory inventory) {
        // TODO: Add logic to save inventory to the database
    }

    @Override
    public Inventory getInventoryById(int id) {
        // TODO: Fetch the inventory by ID from the database
        return null;
    }

    @Override
    public List<Inventory> getAllInventories() {
        // TODO: Fetch all inventories from the database
        return null;
    }

    @Override
    public void updateInventory(Inventory inventory) {
        // TODO: Update the inventory in the database
    }

    @Override
    public void deleteInventory(int id) {
        // TODO: Delete the inventory by ID from the database
    }
}
