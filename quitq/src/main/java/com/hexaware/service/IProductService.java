package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.Product;

public interface IProductService {
	
	    void addProduct(Product product);
	    
	    Product getProductById(int id);
	    
	    List<Product> getAllProducts();
	    
	    void updateProduct(Product product);
	    
	    void deleteProduct(int id);


}
