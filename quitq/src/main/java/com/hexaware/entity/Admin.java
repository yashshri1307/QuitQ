package com.hexaware.entity;

import java.util.Date;

public class Admin {

    private int adminId;
    private String name;
    private String email;
    private String password;
    private String role;
    

    public Admin() {
        super();
    }

    public Admin(int adminId, String name, String email, String password, String role, Date created_at) {
        super();
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setadminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   

    @Override
    public String toString() {
        return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password
                + ", role=" + role + " ]";
    }
}
