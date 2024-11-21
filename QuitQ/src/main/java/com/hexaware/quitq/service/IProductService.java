package com.hexaware.quitq.service;

import java.util.List;

import com.hexaware.quitq.dto.ProductDTO;
import com.hexaware.quitq.entities.Product;

public interface IProductService {
	
	public Product addProduct(ProductDTO productDTO);
    
	public Product getProductById(Integer id);
    
	public List<Product> getAllProducts();
    
	public Product updateProduct(ProductDTO productDTO);
    
    public String deleteProductById(Integer id);
    
    public List<Product> getProductsByPriceRange(double min, double max);

    public List<Product> searchProductByName(String name);
}
