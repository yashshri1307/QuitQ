package com.hexaware.quitq.dto;
/* File: Product DTO
 * Author: Yash Shrivastava
 * Date Created: 2024-11-11
 * Description: Product DTO With Validations 
 *              For Data Transfer between Layers             
 */
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private int productId;
    
    @NotNull 
    private int supplierId;

    @Pattern(regexp = "[A-Za-z]+", message = "Name must contain only alphabetic characters")
    private String name;

    private int categoryId;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Size(max = 200, message = "Description can't exceed 200 characters")
    private String description;

	public ProductDTO() {
		super();
	}

	public ProductDTO(int productId, @NotNull int supplierId,
			@Pattern(regexp = "[A-Za-z]+", message = "Name must contain only alphabetic characters") String name,
			int categoryId, @Positive(message = "Price must be positive") double price,
			@Min(value = 0, message = "Stock cannot be negative") int stock,
			@Size(max = 200, message = "Description can't exceed 200 characters") String description) {
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getSupplierId() {
		return supplierId;
	}



	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", supplierId=" + supplierId + ", name=" + name + ", categoryId="
				+ categoryId + ", price=" + price + ", stock=" + stock + ", description=" + description + "]";
	}  
    
}
