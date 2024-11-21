package com.hexaware.quitq.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

// import java.util.Optional;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryRepository, Integer> {

    List<ProductCategoryRepository> findByName(String name);  // Find product category by name

    List<ProductCategoryRepository> findByDescriptionContaining(String keyword);  // Find product category by description containing a keyword

    @Modifying
    @Query("delete from ProductCategory p where p.name = ?1")
    int deleteByName(String name);  // Delete product category by name
}