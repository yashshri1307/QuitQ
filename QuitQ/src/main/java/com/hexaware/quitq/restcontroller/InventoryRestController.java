/* File: InventoryRestController
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-14
 * Description: Inventory Controller will have api mapping for inventory functionality        
                will take Data using InventoryDTO
                and will transfer to service layer
 */

package com.hexaware.quitq.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.dto.InventoryDTO;
import com.hexaware.quitq.entities.Inventory;
import com.hexaware.quitq.service.IInventoryService;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/inventory")
public class InventoryRestController {

    @Autowired
    IInventoryService service;

    Logger logger = LoggerFactory.getLogger(InventoryRestController.class);

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InventoryDTO> insertInventory(@RequestBody InventoryDTO inventoryDTO) {
        logger.info("insertInventory is called");

        Inventory inventory = convertToEntity(inventoryDTO);
        Inventory savedInventory = service.addInventory(inventory);
        InventoryDTO savedInventoryDTO = convertToDTO(savedInventory);
        return new ResponseEntity<>(savedInventoryDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<InventoryDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
        logger.info("updateInventory is called with ID: " + inventoryDTO.getInventoryId());

        // Validate inventoryId
        if (inventoryDTO.getInventoryId() == 0 || inventoryDTO.getInventoryId() == 0) {
            logger.error("Invalid Inventory ID: ID cannot be zero or null");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        // Proceed with the update
        Inventory inventory = convertToEntity(inventoryDTO);
        Inventory updatedInventory = service.updateInventory(inventory);
        InventoryDTO updatedInventoryDTO = convertToDTO(updatedInventory);
        return new ResponseEntity<>(updatedInventoryDTO, HttpStatus.OK);
    }

    
//    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<InventoryDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
//        logger.info("updateInventory is called with ID: " + inventoryDTO.getInventoryId());
//
//        if (inventoryDTO.getInventoryId() == 0) {
//            logger.error("Invalid Inventory ID: ID cannot be zero or null");
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//
//        Inventory inventory = convertToEntity(inventoryDTO);
//        Inventory updatedInventory = service.updateInventory(inventory);
//        InventoryDTO updatedInventoryDTO = convertToDTO(updatedInventory);
//        return new ResponseEntity<>(updatedInventoryDTO, HttpStatus.OK);
//    }


//    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<InventoryDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
//        logger.info("updateInventory is called");
//
//        Inventory inventory = convertToEntity(inventoryDTO);
//        Inventory updatedInventory = service.updateInventory(inventory);
//        InventoryDTO updatedInventoryDTO = convertToDTO(updatedInventory);
//        return new ResponseEntity<>(updatedInventoryDTO, HttpStatus.OK);
//    }

    @GetMapping(value = "/getbyid/{inventoryId}", produces = "application/json")
    public ResponseEntity<InventoryDTO> getInventoryById(@PathVariable int inventoryId) {
        logger.info("getInventoryById is called for id: " + inventoryId);
        Inventory inventory = service.getInventoryById(inventoryId);
        if (inventory != null) {
            InventoryDTO inventoryDTO = convertToDTO(inventory);
            return new ResponseEntity<>(inventoryDTO, HttpStatus.OK);
        } else {
            logger.warn("Inventory not found for id: " + inventoryId);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<List<InventoryDTO>> getAll() {
        logger.info("getAll is called");
        List<Inventory> inventories = service.getAllInventory();
        List<InventoryDTO> inventoriesDTO = inventories.stream()
                                                       .map(this::convertToDTO)
                                                       .toList();
        return new ResponseEntity<>(inventoriesDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyid/{inventoryId}", produces = "application/json")
    public ResponseEntity<String> deleteById(@PathVariable int inventoryId) {
        logger.warn("deleteById is called for id: " + inventoryId);

        // Check if inventoryId is valid
        if (inventoryId <= 0) {
            logger.error("Invalid Inventory ID: " + inventoryId);
            return new ResponseEntity<>("Invalid ID provided", HttpStatus.BAD_REQUEST);
        }

        String result = service.deleteInventoryById(inventoryId);
        if (result.contains("Inventory not found")) {
            logger.warn("Inventory not found for id: " + inventoryId);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    private InventoryDTO convertToDTO(Inventory inventory) {
        return new InventoryDTO(inventory.getInventoryId(), inventory.getProductId(),
                inventory.getStockQuantity(), inventory.getStockValue(), inventory.getStatus());
    }

    private Inventory convertToEntity(InventoryDTO inventoryDTO) {
        return new Inventory(inventoryDTO.getInventoryId(), inventoryDTO.getProductId(),
                inventoryDTO.getStockQuantity(), inventoryDTO.getStockValue(), inventoryDTO.getStatus());
    }
}
