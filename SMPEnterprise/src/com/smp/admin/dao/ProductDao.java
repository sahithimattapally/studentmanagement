package com.smp.admin.dao;

import java.util.List;

import com.smp.bean.Product;

public interface ProductDao {

	int addproduct(Product pp);
	 
	 Product viewproduct(int product_id);
	 int updateproduct(int product_id);
	 int deleteproduct(int product_id);
	List<Product> viewallProducts();
}
