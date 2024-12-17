package com.hexaware.quitq.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.quitq.dto.ProductDTO;
import com.hexaware.quitq.entities.Product;
import com.hexaware.quitq.entities.Supplier;
import com.hexaware.quitq.repository.IProductRepository;
import com.hexaware.quitq.repository.ISupplierRepository;

@SpringBootTest
class ProductServiceImpTest {

    @InjectMocks
    private ProductServiceImp productService;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private ISupplierRepository supplierRepository;

    @Mock
    private ISupplierService supplierService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Supplier createSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1);
        supplier.setName("TestSupplier");
        supplier.setAddress("123 Test Street");
        supplier.setEmail("testsupplier@example.com");
        return supplier;
    }

    private Product createProduct(Supplier supplier, int productId) {
        Product product = new Product();
        product.setProductId(productId); 
        product.setName("TestProduct");
        product.setDescription("A sample product for testing");
        product.setPrice(150.0);
        product.setSupplier(supplier);
        return product;
    }

    @Test
    @Transactional
    void testAddProduct() {
        Supplier supplier = createSupplier();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("TestProduct");
        productDTO.setDescription("A sample product for testing");
        productDTO.setPrice(150.0);
        productDTO.setSupplierId(supplier.getSupplierId());

       
        when(supplierRepository.findById(supplier.getSupplierId())).thenReturn(Optional.of(supplier));

   
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> {
            Product product = invocation.getArgument(0);
            product.setProductId(1); 
            return product;
        });

        Product product = productService.addProduct(productDTO);

        assertNotNull(product);
        assertEquals("TestProduct", product.getName());
        assertEquals(supplier.getSupplierId(), product.getSupplier().getSupplierId());
    }

    @Test
    @Transactional
    void testUpdateProduct() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier, 1); 

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName("UpdatedProduct");
        productDTO.setDescription("Updated description");
        productDTO.setPrice(200.0);
        productDTO.setSupplierId(supplier.getSupplierId());

        
        when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));
        when(supplierRepository.findById(supplier.getSupplierId())).thenReturn(Optional.of(supplier));

      
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> {
            Product updatedProduct = invocation.getArgument(0);
            updatedProduct.setProductId(product.getProductId()); 
            return updatedProduct;
        });

        Product updatedProduct = productService.updateProduct(productDTO);

        assertNotNull(updatedProduct);
        assertEquals("UpdatedProduct", updatedProduct.getName());
        assertEquals(200.0, updatedProduct.getPrice());
    }

    @Test
    @Transactional
    void testGetProductById() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier, 1); 

        when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));

        Product fetchedProduct = productService.getProductById(product.getProductId());

        assertNotNull(fetchedProduct);
        assertEquals(product.getProductId(), fetchedProduct.getProductId());
    }

    @Test
    @Transactional
    void testDeleteProductById() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier, 1); 

       
        when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));

        
        doNothing().when(productRepository).deleteById(product.getProductId());

       
        
    }

    @Test
    @Transactional
    void testGetProductsByPriceRange() {
        Supplier supplier = createSupplier();

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("AnotherProduct");
        productDTO.setDescription("Another test product");
        productDTO.setPrice(250.0);
        productDTO.setSupplierId(supplier.getSupplierId());

        when(productRepository.findProductsByPriceRange(100.0, 200.0))
                .thenReturn(List.of(createProduct(supplier, 2))); 

        List<Product> products = productService.getProductsByPriceRange(100.0, 200.0);

        assertNotNull(products);
        assertEquals(1, products.size());
    }

    @Test
    @Transactional
    void testSearchProductByName() {
        Supplier supplier = createSupplier();
        Product product = createProduct(supplier, 1); 

        when(productRepository.findByNameContainingIgnoreCase("TestProduct"))
                .thenReturn(List.of(product));

        List<Product> products = productService.searchProductByName("TestProduct");

        assertNotNull(products);
        assertEquals("TestProduct", products.get(0).getName());
    }
}
