/* File: IProductCategoryService
 * Author: Yadnesh shewale
 * Date Created: 2024-11-12
 * Description: Service Interface for product category           
 */
package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.ProductCategory;
import java.util.List;

public interface IProductCategoryService {

    ProductCategory addProductCategory(ProductCategory productCategory);

    ProductCategory updateProductCategory(ProductCategory productCategory);

    ProductCategory getProductCategoryById(int categoryId);

    String deleteProductCategoryById(int categoryId);

    List<ProductCategory> getAllProductCategories();

    List<ProductCategory> getByCategoryName(String name);

    List<ProductCategory> getByDescriptionKeyword(String keyword);

    int deleteByCategoryName(String name);
}
