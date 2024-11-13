package com.hexaware.entity;

public class Inventory {

    private int inventoryId;
    private int productId;
    private int stockQuantity;
    private double stockValue;
    private String location;
    private String status;

    public Inventory() {
        super();
    }

    public Inventory(int inventoryId, int productId, int stockQuantity, double stockValue, String location, String status) {
        super();
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.stockQuantity = stockQuantity;
        this.stockValue = stockValue;
        this.location = location;
        this.status = status;
    }

    public int inventoryId() {
        return inventoryId;
    }

    public void setinventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int productId() {
        return productId;
    }

    public void setproductId(int productId) {
        this.productId = productId;
    }

    public int getSstockQuantity() {
        return stockQuantity;
    }

    public void setstockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getstockValue() {
        return stockValue;
    }

    public void setstockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", stockQuantity=" + stockQuantity
                + ", stockValue=" + stockValue + ", location=" + location + ", status=" + status + "]";
    }
}
