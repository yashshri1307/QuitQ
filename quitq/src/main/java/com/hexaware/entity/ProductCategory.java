package com.hexaware.entity;

public class ProductCategory {

    private int categoryId;
    private String name;
    private String description;

    public ProductCategory() {
        super();
    }

    public ProductCategory(int categoryId, String name, String description) {
        super();
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategory_id(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductCategory [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
    }
}
