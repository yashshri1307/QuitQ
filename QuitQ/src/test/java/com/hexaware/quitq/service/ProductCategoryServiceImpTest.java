/* author : Yadnesh Shewale
 * date : 23/11/2024
 * 
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.entities.ProductCategory;
import com.hexaware.quitq.repository.IProductCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  // Load the full Spring context for integration tests
@Transactional  // Rollback the database changes after each test to maintain a clean state
public class ProductCategoryServiceImpTest {

    @Autowired
    private IProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryServiceImp productCategoryService;  // The actual service we are testing

    private ProductCategory productCategory;

    @BeforeEach
    public void setUp() {
        productCategoryRepository.deleteAll();  // Clear repository before each test
        productCategory = new ProductCategory(1, "Electronics", "Various electronic products");
        productCategoryRepository.save(productCategory);  // Save a default category before each test
    }

    // Test case for adding a Product Category
    @Test
    public void testAddProductCategory() {
        ProductCategory newCategory = new ProductCategory(2, "Home Appliances", "Various home appliances");
        ProductCategory savedCategory = productCategoryService.addProductCategory(newCategory);

        assertNotNull(savedCategory);
        assertEquals("Home Appliances", savedCategory.getName());
        assertEquals("Various home appliances", savedCategory.getDescription());
    }

    // Test case for updating a Product Category
    @Test
    public void testUpdateProductCategory() {
        productCategory.setDescription("Updated description for electronic products");
        ProductCategory updatedCategory = productCategoryService.updateProductCategory(productCategory);

        assertNotNull(updatedCategory);
        assertEquals("Updated description for electronic products", updatedCategory.getDescription());
    }

    // Test case for fetching a Product Category by ID
    @Test
    public void testGetProductCategoryById() {
        Optional<ProductCategory> fetchedCategory = productCategoryRepository.findById(1);
        assertTrue(fetchedCategory.isPresent());
        assertEquals("Electronics", fetchedCategory.get().getName());
        assertEquals("Various electronic products", fetchedCategory.get().getDescription());
    }

    // Test case for deleting a Product Category by ID
    @Test
    public void testDeleteProductCategoryById() {
        String result = productCategoryService.deleteProductCategoryById(1);

        assertEquals("Product Category deleted successfully!", result);

        Optional<ProductCategory> deletedCategory = productCategoryRepository.findById(1);
        assertFalse(deletedCategory.isPresent());
    }

    // Test case for fetching all Product Categories
    @Test
    public void testGetAllProductCategories() {
        List<ProductCategory> categories = productCategoryService.getAllProductCategories();

        assertNotNull(categories);
        assertTrue(categories.size() > 0);
        assertEquals("Electronics", categories.get(0).getName());
    }

    // Test case for fetching Product Categories by Name
    @Test
    public void testGetProductCategoryByName() {
        List<ProductCategory> categories = productCategoryService.getByCategoryName("Electronics");

        assertNotNull(categories);
        assertEquals(1, categories.size());
        assertEquals("Electronics", categories.get(0).getName());
    }

    // Test case for fetching Product Categories by Description
    @Test
    public void testGetProductCategoryByDescription() {
        List<ProductCategory> categories = productCategoryService.getByDescriptionKeyword("electronic");

        assertNotNull(categories);
        assertEquals(1, categories.size());
        assertEquals("Electronics", categories.get(0).getName());
    }

    // Test case for deleting Product Category by Name
    @Test
    public void testDeleteProductCategoryByName() {
        int deletedCount = productCategoryService.deleteByCategoryName("Electronics");

        assertEquals(1, deletedCount);

        // Verify that the category was deleted
        List<ProductCategory> categories = productCategoryRepository.findByName("Electronics");
        assertTrue(categories.isEmpty());
    }
}
