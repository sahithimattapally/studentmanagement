package com.smp.bean;

public class Categories {
	private int cat_id;
	private String name;
	public Categories(int cat_id, String name) {
		super();
		this.cat_id = cat_id;
		this.name = name;
	}
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
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
	

}
