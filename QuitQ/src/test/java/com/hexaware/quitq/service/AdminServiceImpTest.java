/* author : Yadnesh Shewale
 * date : 23/11/2024
 * 
 */

package com.hexaware.quitq.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.repository.IAdminRepository;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdminServiceImpTest {

    @Autowired
    private IAdminService service;

    @Autowired
    private IAdminRepository repo;

    private AdminDTO adminDTO;

    @BeforeAll
    void setup() {
        adminDTO = new AdminDTO();
        adminDTO.setName("Admin Name");
        adminDTO.setEmail("admin@example.com");
        adminDTO.setPassword("Admin123");
        adminDTO.setRole("SUPER_ADMIN");
    }

    @BeforeEach
    void cleanUpBeforeEachTest() {
        repo.findByEmail(adminDTO.getEmail()).ifPresent(admin -> {
            repo.delete(admin); 
        });
    }

    @Test
    void testAddAdmin() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());

        Admin addedAdmin = service.addAdmin(admin);
        assertNotNull(addedAdmin, "Admin should be added successfully");
    }

    @Test
    void testGetAdminById() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());
        
        Admin addedAdmin = service.addAdmin(admin);

        Admin fetchedAdmin = service.getAdminById(addedAdmin.getadminId());
        assertNotNull(fetchedAdmin, "Admin should be fetched by ID");
        assertEquals(addedAdmin.getadminId(), fetchedAdmin.getadminId(), "Admin ID should match");
    }

    @Test
    void testGetAllAdmins() {
        Admin admin1 = new Admin();
        admin1.setName("Admin 1");
        admin1.setEmail("admin1@example.com");
        admin1.setPassword("Admin123");
        admin1.setRole("ADMIN");

        Admin admin2 = new Admin();
        admin2.setName("Admin 2");
        admin2.setEmail("admin2@example.com");
        admin2.setPassword("Admin123");
        admin2.setRole("SUPER ADMIN");

        service.addAdmin(admin1);
        service.addAdmin(admin2);

        List<Admin> allAdmins = service.getAllAdmins();
        assertNotNull(allAdmins, "Admins should be fetched successfully");
        assertTrue(allAdmins.size() >= 2, "At least two admins should exist in the system");
    }

    @Test
    void testUpdateAdmin() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());

        Admin addedAdmin = service.addAdmin(admin);

        admin.setName("Updated Admin Name");
        admin.setRole("ADMIN");

        Admin updatedAdmin = service.updateAdmin(admin);
        
        assertNotNull(updatedAdmin, "Admin should be updated successfully");
        assertEquals("Updated Admin Name", updatedAdmin.getName(), "Admin name should be updated");
        assertEquals("ADMIN", updatedAdmin.getRole(), "Admin role should be updated");
    }

    @Test
    void testDeleteAdminById() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());

        Admin addedAdmin = service.addAdmin(admin);

        service.deleteAdminById(addedAdmin.getadminId());
        
        assertTrue(repo.findById(addedAdmin.getadminId()).isEmpty(), "Admin should be deleted successfully");
    }

    @Test
    void testGetAdminByEmail() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());

        service.addAdmin(admin);
        
        Admin fetchedAdmin = service.getByEmail(adminDTO.getEmail());
        assertNotNull(fetchedAdmin, "Admin should be fetched by email");
        assertEquals(adminDTO.getEmail(), fetchedAdmin.getEmail(), "Admin email should match");
    }

    @Test
    void testGetAdminsByRole() {
        Admin admin1 = new Admin();
        admin1.setName("Admin 1");
        admin1.setEmail("admin1@example.com");
        admin1.setPassword("Admin123");
        admin1.setRole("SUPER_ADMIN");

        Admin admin2 = new Admin();
        admin2.setName("Admin 2");
        admin2.setEmail("admin2@example.com");
        admin2.setPassword("Admin123");
        admin2.setRole("ADMIN");

        service.addAdmin(admin1);
        service.addAdmin(admin2);

        List<Admin> superAdmins = service.getByRole("SUPER_ADMIN");
        assertNotNull(superAdmins, "Admins should be fetched by role");
        assertTrue(superAdmins.size() > 0, "At least one super admin should be fetched");
    }

    @Test
    void testDeleteAdminByEmail() {
        Admin admin = new Admin();
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setRole(adminDTO.getRole());

        service.addAdmin(admin);
        
        int deletedCount = service.deleteByEmail(adminDTO.getEmail());
        assertEquals(1, deletedCount, "One admin should be deleted by email");
    }
}


