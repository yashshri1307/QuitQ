/* author : Yadnesh Shewale
 * date : 02/11/2024
 * description : admin dto class is created 
 */



package com.hexaware.quitq.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;

public class AdminDTO {

    private int adminId;
    
    @Pattern(regexp = "[A-Z][a-z]*", message = "Admin Name must begin with an uppercase letter and contain only letters")
    private String name;

    @Email(message = "Email should be in a valid email format")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]{7,24}", message = "Password must start with uppercase, be between 8 to 25 characters long, and contain only letters")
    private String password;

    @NotEmpty(message = "Role cannot be empty")
    private String role;

    public AdminDTO() {
        super();
    }

    public AdminDTO(int adminId, String name, String email, String password, String role) {
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
