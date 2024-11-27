/* author : Yadnesh Shewale
 * date : 09/11/2024
 * 
 */

package com.hexaware.quitq.service;


import com.hexaware.quitq.entities.Admin;

import java.util.List;

public interface IAdminService {

    // Create a new admin
    public Admin addAdmin(Admin admin);

    // Update an existing admin
    public Admin updateAdmin(Admin admin);

    // Get admin by ID
    public Admin getAdminById(int adminId);

    // Delete admin by ID
    public String deleteAdminById(int adminId);

    // Get all admins
    public List<Admin> getAllAdmins();

    // Get admins by role
    public List<Admin> getByRole(String role);

    // Get admin by email
    public Admin getByEmail(String email);

    // Delete admin by email
    public int deleteByEmail(String email);
}
