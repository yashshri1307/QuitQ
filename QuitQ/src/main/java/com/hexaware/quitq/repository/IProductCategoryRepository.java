/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : Repository interface for ProductCategory entity with custom query methods.
 */
package com.hexaware.quitq.repository;

import com.hexaware.quitq.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    // Find categories by name
    List<ProductCategory> findByName(String name);

    // Find categories where the description contains a keyword
    List<ProductCategory> findByDescriptionContaining(String keyword);

    // Delete categories by name
    @Modifying
    @Query("DELETE FROM ProductCategory pc WHERE pc.name = :name")
    int deleteByName(String name);
}
