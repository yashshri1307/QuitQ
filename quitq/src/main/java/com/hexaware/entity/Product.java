package com.hexaware.entity;

import java.util.Date;

public class Product {

	private int productId;
	private int supplierId;
	private String name;
	private String category;
	private double price;
	private int stock;
	private String description;
	private Date createdAt;
	
	public Product() {
		super();
	}

	public Product(int productId, int supplierId, String name, String category, double price, int stock,
			String description, Date createdAt) {
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.createdAt = createdAt;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", supplierId=" + supplierId + ", name=" + name + ", category="
				+ category + ", price=" + price + ", stock=" + stock + ", description=" + description + ", createdAt="
				+ createdAt + "]";
	}

	
}
