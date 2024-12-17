/* File: Inventory Entity
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-05
 * Description: Inventory Entity With Validations
 */

package com.hexaware.quitq.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventories")  // Specifies the table name in the database
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")  // Maps to "inventory_id" column in the DB
    private int inventoryId;

    private int productId;

    @Column(name = "stockQuantity", nullable = false)
    private int stockQuantity;

    private double stockValue;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    // Default constructor
    public Inventory() {
        super();
    }

    // Parameterized constructor
    public Inventory(int inventoryId, int productId, int stockQuantity, double stockValue, String status) {
        super();
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.stockQuantity = stockQuantity;
        this.stockValue = stockValue;
        this.status = status;
    }

    // Getters and setters
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
        return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", stockQuantity=" + stockQuantity
                + ", stockValue=" + stockValue + ", status=" + status + "]";
    }
}
