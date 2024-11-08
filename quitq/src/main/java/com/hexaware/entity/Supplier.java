package com.hexaware.entity;

import java.util.Date;

public class Supplier {
	
	private int supplier_id;
	private String name;
	private String email;
	private String password;
	private String mob_no;
	private String company_name;
	private String address;
	private Date created_at;
	
	public Supplier() {
		super();
	}

	public Supplier(int supplier_id, String name, String email, String password, String mob_no, String company_name,
			String address, Date created_at) {
		super();
		this.supplier_id = supplier_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mob_no = mob_no;
		this.company_name = company_name;
		this.address = address;
		this.created_at = created_at;
	}


	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
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

	public String getMob_no() {
		return mob_no;
	}

	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mob_no=" + mob_no + ", company_name=" + company_name + ", address=" + address + ", created_at="
				+ created_at + "]";
	}

}
