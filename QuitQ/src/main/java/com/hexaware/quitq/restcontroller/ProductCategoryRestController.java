/* author : Yadnesh Shewale
 * date : 13/11/2024
 * 
 */

package com.hexaware.quitq.restcontroller;
import com.hexaware.quitq.entities.ProductCategory;
import com.hexaware.quitq.service.IProductCategoryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productcategory")
public class ProductCategoryRestController {

    @Autowired
    IProductCategoryService service;

    Logger logger = LoggerFactory.getLogger(ProductCategoryRestController.class);

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProductCategory> insertProductCategory(@RequestBody ProductCategory productCategory) {
        logger.info("insertProductCategory is called");

        if (validateProductCategory(productCategory)) {
            ProductCategory savedCategory = service.addProductCategory(productCategory);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } else {
            logger.error("Failed to add ProductCategory: Invalid data");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProductCategory> updateProductCategory(@RequestBody ProductCategory productCategory) {
        logger.info("updateProductCategory is called");
        ProductCategory updatedCategory = service.updateProductCategory(productCategory);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyid/{categoryId}", produces = "application/json")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable int categoryId) {
        logger.info("getProductCategoryById is called for id: " + categoryId);
        ProductCategory productCategory = service.getProductCategoryById(categoryId);
        if (productCategory != null) {
            return new ResponseEntity<>(productCategory, HttpStatus.OK);
        } else {
            logger.warn("ProductCategory not found for id: " + categoryId);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    
    // below one line is added 
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<List<ProductCategory>> getAll() {
        logger.info("getAll is called");
        List<ProductCategory> categories = service.getAllProductCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyid/{categoryId}", produces = "application/json")
    public ResponseEntity<String> deleteById(@PathVariable int categoryId) {
        logger.warn("deleteById is called for id: " + categoryId);
        String result = service.deleteProductCategoryById(categoryId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyname/{name}", produces = "application/json")
    public ResponseEntity<List<ProductCategory>> getByName(@PathVariable String name) {
        logger.info("getByName is called for name: " + name);
        List<ProductCategory> categories = service.getByCategoryName(name);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/getbydescription/{description}", produces = "application/json")
    public ResponseEntity<List<ProductCategory>> getByDescription(@PathVariable String description) {
        logger.info("getByDescription is called for description: " + description);
        List<ProductCategory> categories = service.getByDescriptionKeyword(description);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyname/{name}", produces = "application/json")
    public ResponseEntity<String> deleteByName(@PathVariable String name) {
        logger.warn("deleteByName is called for name: " + name);
        int count = service.deleteByCategoryName(name);
        return new ResponseEntity<>(count + " record(s) deleted", HttpStatus.OK);
    }

    // Utility method to validate ProductCategory object
    private boolean validateProductCategory(ProductCategory productCategory) {
        return productCategory != null &&
               productCategory.getName() != null && !productCategory.getName().isEmpty() &&
               productCategory.getDescription() != null && !productCategory.getDescription().isEmpty();
    }
}






























/*package com.hexaware.ecommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.ecommerce.entities.ProductCategory;
import com.hexaware.ecommerce.services.IProductCategoryService;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoryController {

    @Autowired
    IProductCategoryService service;

    @PostMapping("/add")
    public ProductCategory insertProductCategory(@RequestBody ProductCategory productCategory) {
        return service.addProductCategory(productCategory);
    }

    @PutMapping("/update")
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
        return service.updateProductCategory(productCategory);
    }

    @GetMapping("/getbyid/{categoryId}")
    public ProductCategory getProductCategoryById(@PathVariable int categoryId) {
        return service.getProductCategoryById(categoryId);
    }

    @GetMapping("/getall")
    public List<ProductCategory> getAll() {
        return service.getAllProductCategories();
    }

    @DeleteMapping("/deletebyid/{categoryId}")
    public String deleteById(@PathVariable int categoryId) {
        return service.deleteProductCategoryById(categoryId);
    }

    @GetMapping("/getbyname/{name}")
    public List<ProductCategory> getByName(@PathVariable String name) {
        return service.getByCategoryName(name);
    }

    @GetMapping("/getbydescription/{description}")
    public List<ProductCategory> getByDescription(@PathVariable String description) {
        return service.getByDescriptionKeyword(description);
    }

    @DeleteMapping("/deletebyname/{name}")
    public String deleteByName(@PathVariable String name) {
        int count = service.deleteByCategoryName(name);
        return count + " record(s) deleted";
    }
}
*/