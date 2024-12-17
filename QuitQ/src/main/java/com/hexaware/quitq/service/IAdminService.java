/* File: IAdminServiceImp
 * Author: Yadnesh shewale
 * Date Created: 2024-11-12
 * Description: Service Interface for Admin           
 */

package com.hexaware.quitq.service;

import com.hexaware.quitq.dto.AdminDTO;
import com.hexaware.quitq.entities.Admin;
import com.hexaware.quitq.entities.Customer;

import java.util.List;

public interface IAdminService {

    AdminDTO addAdmin(AdminDTO adminDTO);  // Accept AdminDTO to directly return DTO

    AdminDTO updateAdmin(AdminDTO adminDTO);

    AdminDTO getAdminById(int adminId);
    
    Admin getAdminByEmail(String email);
    
    public String deleteAdminById(Integer id);

    List<AdminDTO> getAllAdmins();

    AdminDTO toDTO(Admin admin);  // Convert Admin entity to AdminDTO

    Admin toEntity(AdminDTO adminDTO);  // Convert AdminDTO to Admin entity

	// String getAdminRole(String username);
}
