/* File: AdminRestController
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-14
 * Description: Admin Controller will have api mapping for admin functionality        
                will take Data using AdminDTO
                and will transfer to service layer
 */

package com.hexaware.quitq.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.entities.Customer;
import com.hexaware.quitq.service.IAdminService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/admins")
public class AdminRestController {

    @Autowired
    private IAdminService adminService;

    Logger logger = LoggerFactory.getLogger(AdminRestController.class);

    @PostMapping("/add")
    public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO adminDTO) {
        // Add admin using DTO
        AdminDTO savedAdminDTO = adminService.addAdmin(adminDTO);

        return new ResponseEntity<>(savedAdminDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO) {
        logger.info("Updating admin: " + adminDTO);
        AdminDTO updatedAdminDTO = adminService.updateAdmin(adminDTO);

        return new ResponseEntity<>(updatedAdminDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{adminId}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable int adminId) {
        logger.info("Fetching admin with ID: " + adminId);
        AdminDTO adminDTO = adminService.getAdminById(adminId);

        return new ResponseEntity<>(adminDTO, HttpStatus.OK);
    }
    
    @GetMapping("/getAdminByEmail/{email}")
	public  Admin getAdminbyEmail(@PathVariable String email)
	{
		return adminService.getAdminByEmail(email);
	}
    
    @GetMapping("/getall")
	public List<AdminDTO> getAll()
	{
		return adminService.getAllAdmins();
	}
    
    
    @DeleteMapping("/delete/{id}")
	public String deleteAdminById(@PathVariable Integer id)
	{
		return adminService.deleteAdminById(id);
	}
    
    
}
