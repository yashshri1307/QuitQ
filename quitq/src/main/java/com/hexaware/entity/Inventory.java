package com.hexaware.entity;

public class Inventory {

    private int inventory_id;
    private int product_id;
    private int stock_quantity;
    private double stock_value;
    private String location;
    private String status;

    public Inventory() {
        super();
    }

    public Inventory(int inventory_id, int product_id, int stock_quantity, double stock_value, String location, String status) {
        super();
        this.inventory_id = inventory_id;
        this.product_id = product_id;
        this.stock_quantity = stock_quantity;
        this.stock_value = stock_value;
        this.location = location;
        this.status = status;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public double getStock_value() {
        return stock_value;
    }

    public void setStock_value(double stock_value) {
        this.stock_value = stock_value;
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
        return "Inventory [inventory_id=" + inventory_id + ", product_id=" + product_id + ", stock_quantity=" + stock_quantity
                + ", stock_value=" + stock_value + ", location=" + location + ", status=" + status + "]";
    }
}
