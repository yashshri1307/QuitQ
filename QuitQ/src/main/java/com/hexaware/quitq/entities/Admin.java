
/* author : Yadnesh Shewale
 * date : 02/11/2024
 * description : admin dto class is created 
 */

package com.hexaware.quitq.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "admins")  
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "admin_id")  
    private int adminId;

    @Pattern(regexp = "[A-Z][a-z]",message = "Admin Name must begin with Uppercase ")
    private String name;

    
    @Column(name = "email", nullable = false, length = 100, unique = true)  // Unique constraint on email
    @Email(message = "email should be in email format")
    private String email;

    
    @NotEmpty
	@NotBlank
	@Pattern(regexp = "[A-Z][a-z]{7,24}", message = "password start with uppercse , must  be min 8 char and max 25 chars")
	private String password;

    @Column(name = "role")
    private String role;
    
    
    
    public Admin() {
        super();
    }

    public Admin(int adminId, String name, String email, String password, String role, Date createdAt) {
        super();
        this.adminId = adminId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        
    }

    public int getadminId() {
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