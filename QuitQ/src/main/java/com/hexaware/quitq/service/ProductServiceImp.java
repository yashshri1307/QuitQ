package com.hexaware.quitq.service;
/* File: ProductServiceImp
 * Author: Yash Shrivastava
 * Date Created: 2024-11-12
 * Description: Service Implementation for serviceInterface for product          
                Will Contain business logic and 
                will take Data using ProductDTO
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.dto.ProductDTO;
import com.hexaware.quitq.entities.Product;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.exception.ProductNotFoundException;
import com.hexaware.quitq.exception.SupplierNotFoundException;
import com.hexaware.quitq.repository.IProductRepository;
import com.hexaware.quitq.repository.ISupplierRepository;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductRepository repo;
    
    @Autowired
    private ISupplierRepository supplierrepo;

    @Override
    public Product addProduct(ProductDTO productDTO) {
    	
     Supplier supplier = supplierrepo.findById(productDTO.getSupplierId())
    	            .orElseThrow(() -> new SupplierNotFoundException("Supplier not found"));
     
       Product product=new Product();
    	 
      product.setSupplier(supplier);
      product.setName(productDTO.getName());
      product.setCategoryId(productDTO.getCategoryId());
      product.setPrice(productDTO.getPrice());
      product.setStock(productDTO.getStock());
      product.setDescription(productDTO.getDescription());
        return repo.save(product);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
     
    	Product product = repo.findById(productDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productDTO.getProductId() + " not found"));

        Supplier supplier = supplierrepo.findById(productDTO.getSupplierId())
                .orElseThrow(() -> new SupplierNotFoundException("Supplier not found"));
    	
        product.setSupplier(supplier);
        product.setName(productDTO.getName());
        product.setCategoryId(productDTO.getCategoryId());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setDescription(productDTO.getDescription());
        		
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