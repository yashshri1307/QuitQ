package com.hexaware.quitq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.quitq.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max")
    List<Product> findProductsByPriceRange(double min, double max);

    List<Product> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT p FROM Product p WHERE p.supplier.supplierId =:id")
    List<Product> findProductsBySupplierId(Integer id);
 
}

