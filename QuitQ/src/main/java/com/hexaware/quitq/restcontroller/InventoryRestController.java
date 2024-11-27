/* author : Yadnesh Shewale
 * date : 13/11/2024
 * 
 */

package com.hexaware.quitq.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.entities.Inventory;
import com.hexaware.quitq.service.IInventoryService;

@RestController
@RequestMapping("/api/inventories")
public class InventoryRestController {

    @Autowired
    IInventoryService service;

    Logger logger = LoggerFactory.getLogger(InventoryRestController.class);

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Inventory> insertInventory(@RequestBody Inventory inventory) {
        logger.info("insertInventory is called");

        if (validateInventory(inventory)) {
            Inventory savedInventory = service.addInventory(inventory);
            return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
        } else {
            logger.error("Failed to add inventory: Invalid data");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
        logger.info("updateInventory is called");
        Inventory updatedInventory = service.updateInventory(inventory);
        return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyid/{inventoryId}", produces = "application/json")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int inventoryId) {
        logger.info("getInventoryById is called for id: " + inventoryId);
        Inventory inventory = service.getInventoryById(inventoryId);
        if (inventory != null) {
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } else {
            logger.warn("Inventory not found for id: " + inventoryId);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<List<Inventory>> getAll() {
        logger.info("getAll is called");
        List<Inventory> inventories = service.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyid/{inventoryId}", produces = "application/json")
    public ResponseEntity<String> deleteById(@PathVariable int inventoryId) {
        logger.warn("deleteById is called for id: " + inventoryId);
        String result = service.deleteInventoryById(inventoryId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyproductid/{productId}", produces = "application/json")
    public ResponseEntity<List<Inventory>> getByProductId(@PathVariable int productId) {
        logger.info("getByProductId is called for productId: " + productId);
        List<Inventory> inventories = service.getByProductId(productId);
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping(value = "/getbystatus/{status}", produces = "application/json")
    public ResponseEntity<List<Inventory>> getByStatus(@PathVariable String status) {
        logger.info("getByStatus is called for status: " + status);
        List<Inventory> inventories = service.getByStatus(status);
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping(value = "/getbystockquantitygt/{quantity}", produces = "application/json")
    public ResponseEntity<List<Inventory>> getByStockQuantityGreaterThan(@PathVariable int quantity) {
        logger.info("getByStockQuantityGreaterThan is called for quantity > " + quantity);
        List<Inventory> inventories = service.getByStockGreaterThan(quantity);
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyproductid/{productId}", produces = "application/json")
    public ResponseEntity<String> deleteByProductId(@PathVariable int productId) {
        logger.warn("deleteByProductId is called for productId: " + productId);
        int count = service.deleteByProductId(productId);
        return new ResponseEntity<>(count + " record(s) deleted", HttpStatus.OK);
    }

    // Utility method to validate Inventory object
    private boolean validateInventory(Inventory inventory) {
        return inventory != null && inventory.getProductId() != 0 && inventory.getStockQuantity() >= 0;
    }
}

























/*package com.hexaware.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.ecommerce.entities.Inventory;
import com.hexaware.ecommerce.services.IInventoryService;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    IInventoryService service;

    @PostMapping("/add")
    public Inventory insertInventory(@RequestBody Inventory inventory) {
        return service.addInventory(inventory);
    }

    @PutMapping("/update")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return service.updateInventory(inventory);
    }

    @GetMapping("/getbyid/{inventoryId}")
    public Inventory getInventoryById(@PathVariable int inventoryId) {
        return service.getInventoryById(inventoryId);
    }

    @GetMapping("/getall")
    public List<Inventory> getAll() {
        return service.getAllInventory();
    }

    @DeleteMapping("/deletebyid/{inventoryId}")
    public String deleteById(@PathVariable int inventoryId) {
        return service.deleteInventoryById(inventoryId);
    }

    @GetMapping("/getbyproductid/{productId}")
    public List<Inventory> getByProductId(@PathVariable int productId) {
        return service.getByProductId(productId);
    }

    @GetMapping("/getbystatus/{status}")
    public List<Inventory> getByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @GetMapping("/getbystockquantitygt/{quantity}")
    public List<Inventory> getByStockQuantityGreaterThan(@PathVariable int quantity) {
        return service.getByStockGreaterThan(quantity);
    }

    @DeleteMapping("/deletebyproductid/{productId}")
    public String deleteByProductId(@PathVariable int productId) {
        int count = service.deleteByProductId(productId);
        return count + " record(s) deleted";
    }
}
*/