package com.hexaware.quitq.dto;
/* File: Customer DTO
 * Author: Yash Shrivastava
 * Date Created: 2024-11-11
 * Description: Customer DTO With Validations 
 *              For Data Transfer between Layers             
 */
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDTO {

	private int customerId;
	
	@Pattern(regexp = "[A-Za-z]+")
	private String name;
	
	@Email
	@NotNull
	private String email;
	
	@Size(min=8, message = "Password must be at least 8 characters")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, and one digit")
	private String password;
	
	@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be exactly 10 digits")
	private String mobileNumber;
	
	private String address;
	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(int customerId, @Pattern(regexp = "[A-Za-z]+") String name, @Email @NotNull String email,
			@Size(min = 8, message = "Password must be at least 8 characters") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,}$", message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, and one digit") String password,
			@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be exactly 10 digits") String mobileNumber,
			String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}




	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}


}
