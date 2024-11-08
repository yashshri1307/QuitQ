package com.hexaware.entity;

import java.util.Date;

public class Product {

	private int product_id;
	private int supplier_id;
	private String name;
	private String category;
	private double price;
	private int stock;
	private String description;
	private Date created_at;
	
	public Product() {
		super();
	}

	public Product(int product_id, int supplier_id, String name, String category, double price, int stock,
			String description, Date created_at) {
		super();
		this.product_id = product_id;
		this.supplier_id = supplier_id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.description = description;
		this.created_at = created_at;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", supplier_id=" + supplier_id + ", name=" + name + ", category="
				+ category + ", price=" + price + ", stock=" + stock + ", description=" + description + ", created_at="
				+ created_at + "]";
	}

	
}
