 package com.smp.bean;

public class productd {
	private  int product_id;
	private String  name;
    private int qty;
    private int price;
	public productd(int product_id, String name, int qty, int price) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	public productd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
