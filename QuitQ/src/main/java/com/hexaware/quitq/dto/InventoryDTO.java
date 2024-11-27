/* author : Yadnesh Shewale
 * date : 02/11/2024
 * description : inventory dto class is created 
 */


package com.hexaware.quitq.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class InventoryDTO {

    private int inventoryId;

    @NotNull(message = "Product ID cannot be null")
    @Positive(message = "Product ID must be a positive integer")
    private int productId;

    @NotNull(message = "Stock Quantity cannot be null")
    @Positive(message = "Stock Quantity must be a positive integer")
    private int stockQuantity;

    @NotNull(message = "Stock Value cannot be null")
    @Positive(message = "Stock Value must be a positive number")
    private double stockValue;

    @NotNull(message = "Status cannot be null")
    @Size(min = 3, max = 20, message = "Status must be between 3 and 20 characters long")
    private String status;

    public InventoryDTO() {
        super();
    }

    public InventoryDTO(int inventoryId, int productId, int stockQuantity, double stockValue, String status) {
        super();
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.stockQuantity = stockQuantity;
        this.stockValue = stockValue;
        this.status = status;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = stockValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InventoryDTO [inventoryId=" + inventoryId + ", productId=" + productId + ", stockQuantity=" + stockQuantity
                + ", stockValue=" + stockValue + ", status=" + status + "]";
    }
}
