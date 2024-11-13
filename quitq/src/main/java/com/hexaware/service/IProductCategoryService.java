package com.hexaware.service;

import java.util.List;

import com.hexaware.entity.ProductCategory;

public interface IProductCategoryService {
    void addProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryById(int id);

    List<ProductCategory> getAllProductCategories();  

    void updateProductCategory(ProductCategory productCategory);

    void deleteProductCategory(int id);
}
