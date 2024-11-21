
/* author : Yadnesh Shewale 
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
@Table(name = "product_categories")  // Specifies the table name in the database
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID using auto-increment
    @Column(name = "category_id")  // Maps to the "category_id" column in the DB
    private int categoryId;

    @Column(name = "categoryname", nullable = false, length = 30)
    private String name;

    @Size(min = 5, max = 20, message = "productdescription must be min10 and max200 size")
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
