package com.hexaware.quitq.entities;
/* File: Supplier Entity
 * Author: Yash Shrivastava
 * Date Created: 2024-11-06
 * Description: Supplier Entity With Validations
 */
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	
	@Pattern(regexp="[A-Za-z]+")
	private String name;
	
	@Email
	private String email;
	
	@Size(min=8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, and one digit")
	private String password;
	
	@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be exactly 10 digits")
	private String mobileNumber;
	
	private String companyName;
	
	private String address;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	
	public Supplier() {
		super();
	}

	public Supplier(int supplierId, String name, String email, String password, String mobileNumber, String companyName,
			String address, Date createdAt) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.companyName = companyName;
		this.address = address;
		this.createdAt = createdAt;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", companyName=" + companyName + ", address=" + address + ", createdAt=" + createdAt
				+ "]";
	}

}
