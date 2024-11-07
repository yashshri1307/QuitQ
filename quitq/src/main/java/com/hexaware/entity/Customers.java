package com.hexaware.entity;

public class Customers {
	
	private int customer_id;
	private String name;
	private String email;
	private String password;
	private String mob_no;
	private String address;
	
	
	public Customers() {
		super();
	}


	public Customers(int customer_id, String name, String email, String password, String mob_no, String address) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mob_no = mob_no;
		this.address = address;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mob_no=" + mob_no + ", address=" + address + "]";
	}
	
	

}
