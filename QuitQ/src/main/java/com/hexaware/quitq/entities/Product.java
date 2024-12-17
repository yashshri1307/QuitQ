package com.hexaware.quitq.entities;
/* File: Product Entity
 * Author: Yash Shrivastava
 * Date Created: 2024-11-06
 * Description: Product Entity With Validations
 */
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;

    private String name;

    private int categoryId;

    @Positive(message = "Price must be positive")
    private double price;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Size(max = 200, message = "Description can't exceed 200 characters")
    private String description;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    
    private String imageUrl;

    
	public Product() {
		super();
	}

	public Product(int productId, Supplier supplier, String name, int categoryId,
			@Positive(message = "Price must be positive") double price,
			@Min(value = 0, message = "Stock cannot be negative") int stock,
			@Size(max = 200, message = "Description can't exceed 200 characters") String description, Date createdAt,
			String imageUrl) {
		super();
		this.productId = productId;
		this.supplier = supplier;
		this.name = name;
		this.categoryId = categoryId;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.createdAt = createdAt;
		this.imageUrl = imageUrl;
	}




	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", supplier=" + supplier + ", name=" + name + ", categoryId="
				+ categoryId + ", price=" + price + ", stock=" + stock + ", description=" + description + ", createdAt="
				+ createdAt + ", imageUrl=" + imageUrl + "]";
	}

   
		
}
