/* File: Admin DTO
 * Author: Yadnesh Shewale
 * Date Created: 2024-11-11
 * Description: Admin DTO With Validations 
 *              For Data Transfer between Layers             
 */

package com.hexaware.quitq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AdminDTO {

    private int adminId;  // Add adminId here so it can be mapped correctly

    @NotBlank(message = "Admin Name is required and must start with an uppercase letter")
    private String name;

    @Email(message = "Email should be in a valid email format")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @NotBlank(message = "Password cannot be blank")
    // Simplified validation: Just check minimum length for password
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    @NotEmpty(message = "Role cannot be empty")
    private String role;

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
        return "AdminDTO [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + "]";
    }
}



//package com.hexaware.quitq.dto;
//
//import org.antlr.v4.runtime.misc.NotNull;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//
//public class AdminDTO {
//
//    @NotNull
//    private int adminId;  // Add adminId here so it can be mapped correctly
//
//    @Pattern(regexp = "[A-Z][a-z]*", message = "Admin Name must begin with an uppercase letter and contain only letters")
//    private String name;
//
//    @Email(message = "Email should be in a valid email format")
//    @NotEmpty(message = "Email cannot be empty")
//    private String email;
//
//    @NotEmpty
//    @NotBlank
//    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,25}", message = "Password must have at least one uppercase, one lowercase, one number, one special character, and be 8-25 characters long.")
//    private String password;
//
//    @NotEmpty(message = "Role cannot be empty")
//    private String role;
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
//        return "AdminDTO [adminId=" + adminId + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + "]";
//    }
//}
