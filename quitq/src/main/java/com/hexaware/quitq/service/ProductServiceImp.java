package com.hexaware.quitq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.Product;
import com.hexaware.quitq.exception.ProductNotFoundException;
import com.hexaware.quitq.repository.IProductRepository;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductRepository repo;

    @Override
    public Product addProduct(Product product) {
    	
        return repo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
     
        return repo.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public String deleteProductById(Integer id) {
        if (!repo.existsById(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        repo.deleteById(id);
        return "Product deleted successfully";
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) {
        return repo.findProductsByPriceRange(min, max);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}