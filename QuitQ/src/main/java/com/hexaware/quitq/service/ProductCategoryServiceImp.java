package com.hexaware.quitq.service;


import java.util.List;

import com.hexaware.quitq.entities.ProductCategory;
import com.hexaware.quitq.repository.IProductCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductCategoryServiceImp implements IProductCategoryService {

    @Autowired
    private IProductCategoryRepository repo;

    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        return repo.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return repo.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(int categoryId) {
        return repo.findById(categoryId).orElse(null);
    }

    @Override
    public String deleteProductCategoryById(int categoryId) {
        repo.deleteById(categoryId);
        return "Product Category Record Deleted";
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return repo.findAll();
    }

    @Override
    public List<ProductCategory> getByCategoryName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<ProductCategory> getByDescriptionKeyword(String keyword) {
        return repo.findByDescriptionContaining(keyword);
    }

    @Override
    public int deleteByCategoryName(String name) {
        return repo.deleteByName(name);
    }
}

