package com.hexaware.entity;

import java.util.Date;

public class Admin {

    private int admin_id;
    private String name;
    private String email;
    private String password;
    private String role;
    

    public Admin() {
        super();
    }

    public Admin(int admin_id, String name, String email, String password, String role, Date created_at) {
        super();
        this.admin_id = admin_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
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
        return "Admin [admin_id=" + admin_id + ", name=" + name + ", email=" + email + ", password=" + password
                + ", role=" + role + " ]";
    }
}
