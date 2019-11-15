package com.smp.bean;

public class Product {
	private int product_id;
	private int cat_id;
	private String name;
	private int price;
	private int quantity;
	public Product(int product_id, int cat_id, String name, int price, int quantity) {
		super();
		this.product_id = product_id;
		this.cat_id = cat_id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getqty() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
