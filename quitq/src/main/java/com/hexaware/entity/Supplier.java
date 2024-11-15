package com.hexaware.entity;

import java.util.Date;

public class Supplier {
	
	private int supplierId;
	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String companyName;
	private String address;
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
