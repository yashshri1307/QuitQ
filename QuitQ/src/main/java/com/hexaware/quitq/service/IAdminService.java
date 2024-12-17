

package com.hexaware.quitq.service;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;

import java.util.List;

public interface IAdminService {

    AdminDTO addAdmin(AdminDTO adminDTO);  // Accept AdminDTO to directly return DTO

    AdminDTO updateAdmin(AdminDTO adminDTO);

    AdminDTO getAdminById(int adminId);

    List<AdminDTO> getAllAdmins();

    AdminDTO toDTO(Admin admin);  // Convert Admin entity to AdminDTO

    Admin toEntity(AdminDTO adminDTO);  // Convert AdminDTO to Admin entity

	// String getAdminRole(String username);
}
