package com.hexaware.quitq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SupplierDTO {

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
	
	
	public SupplierDTO() {
		super();
	}

	public SupplierDTO(int supplierId, @Pattern(regexp = "[A-Za-z]+") String name, @Email String email,
			@Size(min = 8, message = "Password must be at least 8 characters") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, and one digit") String password,
			@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be exactly 10 digits") String mobileNumber,
			String companyName, String address) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.companyName = companyName;
		this.address = address;
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

	@Override
	public String toString() {
		return "SupplierDTO [supplierId=" + supplierId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", companyName=" + companyName + ", address=" + address
				+ "]";
	}

	
}
