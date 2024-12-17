/* File: AdminServiceImp
 * Author: Yadnesh shewale
 * Date Created: 2024-11-12
 * Description: Service Interface implementation for Admin           
 */
package com.hexaware.quitq.service;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.entities.UserInfo;
import com.hexaware.quitq.exception.AdminNotFoundException;
import com.hexaware.quitq.exception.CustomerNotFoundException;
import com.hexaware.quitq.exception.ProductNotFoundException;
import com.hexaware.quitq.exception.AdminAlreadyExistsException;  // Uncomment this if you want to use this exception
import com.hexaware.quitq.repository.IAdminRepository;
import com.hexaware.quitq.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminServiceImp implements IAdminService {

    @Autowired
    private IAdminRepository adminRepo;

    @Autowired
    private UserInfoRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(AdminServiceImp.class);

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        // Check if admin already exists with the same email
        if (adminRepo.findByEmail(adminDTO.getEmail()).isPresent()) {
            logger.warn("Admin with email " + adminDTO.getEmail() + " already exists.");
            throw new AdminAlreadyExistsException("Admin with email already exists.");  // Throw the exception
        }

        // Convert AdminDTO to Admin entity
        Admin admin = toEntity(adminDTO);
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));  // Encode password
        Admin savedAdmin = adminRepo.save(admin);

        // Save user info
        UserInfo userInfo = new UserInfo();
        userInfo.setId(savedAdmin.getAdminId());
        userInfo.setName(savedAdmin.getName());
        userInfo.setEmail(savedAdmin.getEmail());
        userInfo.setPassword(savedAdmin.getPassword());
        userInfo.setRoles("ADMIN");
        userRepo.save(userInfo);

        logger.info("Admin added: " + adminDTO);
        return toDTO(savedAdmin);
    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO) {
        Admin existingAdmin = adminRepo.findById(adminDTO.getAdminId())
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + adminDTO.getAdminId()));

        existingAdmin.setEmail(adminDTO.getEmail());
        existingAdmin.setRole(adminDTO.getRole());
        if (adminDTO.getPassword() != null && !adminDTO.getPassword().isEmpty()) {
            existingAdmin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));  // Only update if password is provided
        }

        Admin updatedAdmin = adminRepo.save(existingAdmin);

        // Update UserInfo
        UserInfo userInfo = userRepo.findByEmail(existingAdmin.getEmail())
                .orElseThrow(() -> new AdminNotFoundException("UserInfo not found with email: " + existingAdmin.getEmail()));
        userInfo.setRoles(adminDTO.getRole());
        if (adminDTO.getPassword() != null && !adminDTO.getPassword().isEmpty()) {
            userInfo.setPassword(existingAdmin.getPassword());
        }
        userRepo.save(userInfo);

        logger.info("Admin updated: " + adminDTO);
        return toDTO(updatedAdmin);
    }

    @Override
    public AdminDTO getAdminById(int adminId) {
        Admin admin = adminRepo.findById(adminId)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with id: " + adminId));
        return toDTO(admin);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return adminRepo.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdminDTO toDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setAdminId(admin.getAdminId());  // Include adminId
        adminDTO.setName(admin.getName());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setRole(admin.getRole());
        return adminDTO;
    }

    @Override
    public Admin toEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setAdminId(adminDTO.getAdminId());  // Include adminId
        admin.setName(adminDTO.getName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());  // Password will be encoded later
        admin.setRole(adminDTO.getRole());
        return admin;
    }

	@Override
	public Admin getAdminByEmail(String email) {
		return adminRepo.findByEmail(email).orElseThrow(() -> new AdminNotFoundException("Admin with email " + email + " not found."));
		
	}
	
	@Override
    public String deleteAdminById(Integer id) {
        if (!adminRepo.existsById(id)) {
            throw new ProductNotFoundException("Admin with ID " + id + " not found");
        }
        adminRepo.deleteById(id);
        return "Admin deleted successfully";
    }
}
