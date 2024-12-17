/* author : Yadnesh Shewale
 * date : 13/12/2024
 * description : ProductCategory service interface with CRUD operations.
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
