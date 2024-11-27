package com.hexaware.quitq.restcontroller;
/* File: ProductRestController
 * Author: Yash Shrivastava
 * Date Created: 2024-11-14
 * Description: product Controller will have api mapping for product functionality        
                will take Data using productrDTO
                and will transfer to service layer
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.quitq.dto.ProductDTO;
import com.hexaware.quitq.entities.Product;
import com.hexaware.quitq.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	IProductService service;
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody ProductDTO productDTO)
	{
		return service.addProduct(productDTO);
	}
	
	@GetMapping("/getproduct/{id}")
	public Product getproductById(@PathVariable Integer id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/getall")
	public List<Product> getall()
	{
		return service.getAllProducts();
	}
	
	@PutMapping("/updateproduct")
	public Product updateproduct(@RequestBody ProductDTO productDTO)
	{
		return service.updateProduct(productDTO);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteproductById(@PathVariable Integer id)
	{
		return service.deleteProductById(id);
	}

	@GetMapping("/getproductsinRange/{min}/{max}")
	public List<Product> findProductinRange(@PathVariable Double min,@PathVariable Double max)
	{
		return service.getProductsByPriceRange(min, max);
	}
	
	@GetMapping("/searchproduct/{name}")
	public List<Product> searchproductByName(@PathVariable String name)
	{
		return service.searchProductByName(name);
	}
 }
