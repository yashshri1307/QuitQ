/* author : Yadnesh Shewale
 * date : 09/11/2024
 * 
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.Inventory;
import java.util.List;

public interface IInventoryService {

    public Inventory addInventory(Inventory inventory);

    public Inventory updateInventory(Inventory inventory);

    public Inventory getInventoryById(int inventoryId);

    public String deleteInventoryById(int inventoryId);

    public List<Inventory> getAllInventory();

    public List<Inventory> getByProductId(int productId);

    public List<Inventory> getByStockGreaterThan(int stockQuantity);

    public List<Inventory> getByStatus(String status);
}
