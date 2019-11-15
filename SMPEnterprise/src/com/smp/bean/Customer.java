package com.smp.bean;

public class Customer {
	private int customer_id;
	private String forename;
	private String surname;
	private String add1;
	private String add2;
	private String add3;
	private int post_code;
	private long phone;
	private String email;
	public Customer(int customer_id, String forename, String surname, String add1, String add2, String add3,
			int post_code, long phone, String email) {
		super();
		this.customer_id = customer_id;
		this.forename = forename;
		this.surname = surname;
		this.add1 = add1;
		this.add2 = add2;
		this.add3 = add3;
		this.post_code = post_code;
		this.phone = phone;
		this.email = email;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public String getAdd3() {
		return add3;
	}
	public void setAdd3(String add3) {
		this.add3 = add3;
	}
	public int getPost_code() {
		return post_code;
	}
	public void setPost_code(int post_code) {
		this.post_code = post_code;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
