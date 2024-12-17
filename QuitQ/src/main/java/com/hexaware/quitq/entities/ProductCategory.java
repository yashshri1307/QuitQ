/* File: ProductCategory Entity
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-05
 * Description: ProductCategory Entity With Validations
 */
package com.hexaware.quitq.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "categoryname", nullable = false, length = 30)
    private String name;

    @Size(min = 5, max = 200, message = "Product description must be between 5 and 200 characters")
    @Column(name = "description", nullable = false)
    private String description;

    // Default constructor
    public ProductCategory() {
    }

    // Parameterized constructor
    public ProductCategory(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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
