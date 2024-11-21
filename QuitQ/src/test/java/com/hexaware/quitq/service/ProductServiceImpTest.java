package com.hexaware.quitq.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.quitq.dto.ProductDTO;
import com.hexaware.quitq.dto.SupplierDTO;
import com.hexaware.quitq.entities.Product;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.exception.ProductNotFoundException;

@SpringBootTest
class ProductServiceImpTest {

    @Autowired
    private IProductService productService;

    @Autowired
    private ISupplierService supplierService;

    // Helper method to create a supplier
    private Supplier createSupplier() {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName("TestSupplier");
        supplierDTO.setAddress("123 Test Street");
        supplierDTO.setEmail("testsupplier@example.com"); // Unique email
        return supplierService.addSupplier(supplierDTO);
    }

    // Helper method to create a product
    private Product createProduct(Supplier supplier) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("TestProduct");
        productDTO.setDescription("A sample product for testing");
        productDTO.setPrice(150.0);
        productDTO.setSupplierId(supplier.getSupplierId());
        return productService.addProduct(productDTO);
    }

    @Test
    @Transactional
    void testAddProduct() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier);

        assertNotNull(product);
        assertEquals("TestProduct", product.getName());
        assertEquals(supplier.getSupplierId(), product.getSupplier().getSupplierId());
    }

    @Test
    @Transactional
    void testUpdateProduct() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName("UpdatedProduct");
        productDTO.setDescription("Updated description");
        productDTO.setPrice(200.0);
        productDTO.setSupplierId(supplier.getSupplierId());

        Product updatedProduct = productService.updateProduct(productDTO);

        assertNotNull(updatedProduct);
        assertEquals("UpdatedProduct", updatedProduct.getName());
        assertEquals(200.0, updatedProduct.getPrice());
    }

    @Test
    @Transactional
    void testGetProductById() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier);

        Product fetchedProduct = productService.getProductById(product.getProductId());

        assertNotNull(fetchedProduct);
        assertEquals(product.getProductId(), fetchedProduct.getProductId());
    }

    @Test
    @Transactional
    void testGetAllProducts() {
        Supplier supplier = createSupplier();
        createProduct(supplier);

        List<Product> products = productService.getAllProducts();

        assertNotNull(products);
    }

    @Test
    @Transactional
    void testDeleteProductById() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier);

        productService.deleteProductById(product.getProductId());

        assertThrows(ProductNotFoundException.class, () -> {
            productService.getProductById(product.getProductId());
        });
    }

    @Test
    @Transactional
    void testGetProductsByPriceRange() {
        Supplier supplier = createSupplier();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("AnotherProduct");
        productDTO.setDescription("Another test product");
        productDTO.setPrice(250.0);
        productDTO.setSupplierId((supplier.getSupplierId()));
        productService.addProduct(productDTO);

        List<Product> products = productService.getProductsByPriceRange(100.0, 200.0);

        assertNotNull(products);
    }

    @Test
    @Transactional
    void testSearchProductByName() {
        Supplier supplier = createSupplier();
        createProduct(supplier);

        List<Product> products = productService.searchProductByName("TestProduct");

        assertNotNull(products);
 
        assertEquals("TestProduct", products.get(0).getName());
    }
}
