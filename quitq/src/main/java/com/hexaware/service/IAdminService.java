package com.hexaware.service;

import com.hexaware.entity.Admin;
import java.util.List;

public interface IAdminService {
    void addAdmin(Admin admin);

    Admin getAdminById(int id);

    List<Admin> getAllAdmins();

    void updateAdmin(Admin admin);

    void deleteAdmin(int id);
}
