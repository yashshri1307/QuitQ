package com.hexaware.quitq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hexaware.quitq.entities.Inventory;
import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findByProductId(int productId);  // Find inventory by product ID

    List<Inventory> findByStatus(String status);  // Find inventory by status (e.g., "active", "inactive")

    List<Inventory> findByStockQuantityGreaterThan(int stockQuantity);  // Find inventory with stock greater than the given quantity

    @Modifying
    @Query("delete from Inventory i where i.productId = ?1")
    int deleteByProductId(int productId);  // Delete inventory by product ID
}
