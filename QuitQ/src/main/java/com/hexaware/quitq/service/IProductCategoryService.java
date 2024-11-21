package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.ProductCategory;

import java.util.List;

public interface IProductCategoryService {

    // Create a new product category
    public ProductCategory addProductCategory(ProductCategory productCategory);

    // Update an existing product category
    public ProductCategory updateProductCategory(ProductCategory productCategory);

    // Get product category by ID
    public ProductCategory getProductCategoryById(int categoryId);

    // Delete product category by ID
    public String deleteProductCategoryById(int categoryId);

    // Get all product categories
    public List<ProductCategory> getAllProductCategories();

    // Get product categories by name
    public List<ProductCategory> getByCategoryName(String name);

    // Get product categories containing a specific keyword in description
    public List<ProductCategory> getByDescriptionKeyword(String keyword);

    // Delete product category by name
    public int deleteByCategoryName(String name);
}
