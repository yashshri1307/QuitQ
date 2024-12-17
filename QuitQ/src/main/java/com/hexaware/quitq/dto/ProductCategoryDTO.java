/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : ProductCategoryDTO class for data transfer between layers.
 */
package com.hexaware.quitq.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductCategoryDTO {

    private int categoryId;

    @NotNull(message = "Category name cannot be null")
    @Size(min = 1, max = 30, message = "Category name must be between 1 and 30 characters")
    private String name;

    @Size(min = 5, max = 200, message = "Product description must be between 5 and 200 characters")
    private String description;

    // Default constructor
    public ProductCategoryDTO() {
    }

    // Parameterized constructor
    public ProductCategoryDTO(int categoryId, String name, String description) {
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
        return "ProductCategoryDTO [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
    }
}
