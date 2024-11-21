package com.hexaware.quitq.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.services.IAdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    IAdminService service;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) {
        logger.info("insertAdmin is called");

        ResponseEntity<Admin> responseEntity;
        Admin savedAdmin = null;

        if (validateAdmin(admin)) {
            savedAdmin = service.addAdmin(admin);
            responseEntity = new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
            logger.info("Admin added successfully");
        } else {
            responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            logger.error("Admin add failed: invalid data");
        }

        return responseEntity;
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
        logger.info("updateAdmin is called");
        Admin updatedAdmin = service.updateAdmin(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyid/{adminId}", produces = "application/json")
    public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {
        logger.info("getAdminById is called for id: " + adminId);
        Admin admin = service.getAdminById(adminId);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            logger.warn("Admin not found for id: " + adminId);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/getall", produces = "application/json")
    public ResponseEntity<List<Admin>> getAll() {
        logger.info("getAll is called");
        List<Admin> adminList = service.getAllAdmins();
        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletebyid/{adminId}", produces = "application/json")
    public ResponseEntity<String> deleteById(@PathVariable int adminId) {
        logger.warn("deleteById is called for id: " + adminId);
        String result = service.deleteAdminById(adminId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyrole/{role}", produces = "application/json")
    public ResponseEntity<List<Admin>> getByRole(@PathVariable String role) {
        logger.info("getByRole is called for role: " + role);
        List<Admin> adminList = service.getByRole(role);
        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    @GetMapping(value = "/getbyemail/{email}", produces = "application/json")
    public ResponseEntity<Admin> getByEmail(@PathVariable String email) {
        logger.info("getByEmail is called for email: " + email);
        Admin admin = service.getByEmail(email);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            logger.warn("Admin not found for email: " + email);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deletebyemail/{email}", produces = "application/json")
    public ResponseEntity<String> deleteByEmail(@PathVariable String email) {
        logger.warn("deleteByEmail is called for email: " + email);
        int count = service.deleteByEmail(email);
        return new ResponseEntity<>(count + " record(s) deleted", HttpStatus.OK);
    }

    // Utility method to validate Admin object
    private boolean validateAdmin(Admin admin) {
        return admin != null && admin.getName() != null && !admin.getName().isEmpty() &&
                admin.getEmail() != null && !admin.getEmail().isEmpty();
    }
}
