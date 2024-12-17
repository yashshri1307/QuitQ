/* author : Yadnesh Shewale
 * date : 13/11/2024
 */

package com.hexaware.quitq.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.service.IAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
