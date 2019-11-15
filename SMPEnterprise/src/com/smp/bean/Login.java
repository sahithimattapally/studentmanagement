package com.smp.bean;

public class Login {
  private int login_id;
  private int customer_id;
  private String username;
  private String password;
public Login(int login_id, int customer_id, String username, String password) {
	super();
	this.login_id = login_id;
	this.customer_id = customer_id;
	this.username = username;
	this.password = password;
}
public Login() {
	super();
	// TODO Auto-generated constructor stub
}
public int getLogin_id() {
	return login_id;
}
public void setLogin_id(int login_id) {
	this.login_id = login_id;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  

}
