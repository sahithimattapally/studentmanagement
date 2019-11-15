package com.smp.bean;

public class Order_items {
	private int order_items_id;
	private int order_id;
	private int product_id;
	private int quantity;
	public Order_items(int order_items_id, int order_id, int product_id, int quantity) {
		super();
		this.order_items_id = order_items_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public Order_items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrder_items_id() {
		return order_items_id;
	}
	public void setOrder_items_id(int order_items_id) {
		this.order_items_id = order_items_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
