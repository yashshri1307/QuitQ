package com.hexaware.quitq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.repository.IAdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImp implements IAdminService {

    @Autowired
    private IAdminRepository adminRepo;

    Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);

    @Override
    public Admin addAdmin(Admin admin) {
        logger.info("addAdmin service is called");
        
        if (validateAdmin(admin)) {
            return adminRepo.save(admin);
        } else {
            logger.error("Failed to add Admin: Validation failed");
            throw new IllegalArgumentException("Invalid Admin data");
        }
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        logger.info("updateAdmin service is called");

        if (validateAdmin(admin)) {
            return adminRepo.save(admin);
        } else {
            logger.error("Failed to update Admin: Validation failed");
            throw new IllegalArgumentException("Invalid Admin data");
        }
    }

    @Override
    public Admin getAdminById(int adminId) {
        logger.info("getAdminById service is called for id: " + adminId);
        return adminRepo.findById(adminId).orElse(null);
    }

    @Override
    public String deleteAdminById(int adminId) {
        logger.warn("deleteAdminById service is called for id: " + adminId);
        adminRepo.deleteById(adminId);
        logger.debug("Admin record deleted for id: " + adminId);
        return "Admin Record Deleted";
    }

    @Override
    public List<Admin> getAllAdmins() {
        logger.info("getAllAdmins service is called");
        return adminRepo.findAll();
    }

    @Override
    public List<Admin> getByRole(String role) {
        logger.info("getByRole service is called for role: " + role);
        return adminRepo.findByRole(role);
    }

    @Override
    public Admin getByEmail(String email) {
        logger.info("getByEmail service is called for email: " + email);
        return adminRepo.findByEmail(email).orElse(null);
    }

    @Override
    public int deleteByEmail(String email) {
        logger.warn("deleteByEmail service is called for email: " + email);
        int count = adminRepo.deleteByEmail(email);
        logger.debug("Admin record(s) deleted for email: " + email);
        return count;
    }

    // Input validation for Admin
    public static boolean validateAdmin(Admin admin) {
        boolean isValid = false;

        if (admin != null && admin.getName() != null && admin.getName().length() >= 3 &&
            admin.getEmail() != null && admin.getEmail().contains("@")) {
            isValid = true;
        }

        return isValid;
    }
}

































/*package com.hexaware.ecommerce.services;

import java.util.List;

import com.hexaware.ecommerce.entities.Admin;
import com.hexaware.ecommerce.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImp implements IAdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private UserRepository userRepo; // Define and autowire UserRepository

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin getAdminById(int adminId) {
        return adminRepo.findById(adminId).orElse(null);
    }

    @Override
    public String deleteAdminById(int adminId) {
        adminRepo.deleteById(adminId);
        return "Admin Record Deleted";
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepo.findAll();
    }

    @Override
    public List<Admin> getByRole(String role) {
        return adminRepo.findByRole(role);
    }

    @Override
    public Admin getByEmail(String email) {
        return adminRepo.findByEmail(email).orElse(null);
    }

    @Override
    public int deleteByEmail(String email) {
        return adminRepo.deleteByEmail(email);
    }

    
}
*/