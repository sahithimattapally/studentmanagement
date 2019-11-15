package com.smp.bean;

public class Orders {
	private int order_id;
	private int customer_id;
	private  int delivery_add_id;
	private String  payment_type;
	private String status;
	private int total;
	public Orders(int order_id, int customer_id, int delivery_add_id, String payment_type, String status, int total) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.delivery_add_id = delivery_add_id;
		this.payment_type = payment_type;
		this.status = status;
		this.total = total;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getDelivery_add_id() {
		return delivery_add_id;
	}
	public void setDelivery_add_id(int delivery_add_id) {
		this.delivery_add_id = delivery_add_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	

	

}
