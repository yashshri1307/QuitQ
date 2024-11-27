/* author : Yadnesh Shewale
 * date : 11/11/2024
 * 
 */


package com.hexaware.quitq.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.quitq.entities.ProductCategory;

// import java.util.Optional;

@Repository
public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByName(String name);  // Find product category by name

    List<ProductCategory> findByDescriptionContaining(String keyword);  // Find product category by description containing a keyword

    @Modifying
    @Query("delete from ProductCategory p where p.name = ?1")
    int deleteByName(String name);  // Delete product category by name
}
