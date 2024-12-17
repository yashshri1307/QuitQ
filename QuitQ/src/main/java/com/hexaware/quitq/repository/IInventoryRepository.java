/* author : Yadnesh Shewale
 * date : 09/11/2024
 * description : Repository for Inventory entity.
 */

package com.hexaware.quitq.repository;

import com.hexaware.quitq.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IInventoryRepository extends JpaRepository<Inventory, Integer> {

    List<Inventory> findByProductId(int productId);

    List<Inventory> findByStockQuantityGreaterThan(int stockQuantity);

    List<Inventory> findByStatus(String status);
}
