/* File: Admin Entity
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-05
 * Description: Admin Entity With Validations
 */

package com.hexaware.quitq.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int adminId;

    @NotBlank(message = "Admin Name is required and must start with an uppercase letter")
    private String name;

    @Email(message = "Email should be in valid email format")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be blank")
    // Simplified password validation: just check for minimum length
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @Column(name = "role")
    private String role;

    public Admin() {
    }

    public Admin(int adminId, String name, String email, String password, String role) {
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
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
        return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + "]";
    }
}


//package com.hexaware.quitq.entities;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//
//@Entity
//@Table(name = "admins")
//public class Admin {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "admin_id")
//    private int adminId;
//
//    @Pattern(regexp = "[A-Z][a-z]*", message = "Admin Name must begin with Uppercase")
//    private String name;
//
//    @Email(message = "Email should be in valid email format")
//    @Column(name = "email", nullable = false, length = 100, unique = true)
//    private String email;
//
//    @NotEmpty
//    @NotBlank
//    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,25}", message = "Password must contain at least one uppercase, one lowercase, one number, and one special character")
//    private String password;
//
//    @Column(name = "role")
//    private String role;
//
//    public Admin() {
//    }
//
//    public Admin(int adminId, String name, String email, String password, String role) {
//        this.adminId = adminId;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.role = role;
//    }
//
//    // Getters and Setters
//    public int getAdminId() {
//        return adminId;
//    }
//
//    public void setAdminId(int adminId) {
//        this.adminId = adminId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + "]";
//    }
//}
