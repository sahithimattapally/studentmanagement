package com.smp.user.dao;

import com.smp.bean.Order_items;
import com.smp.bean.Product;

public interface OrderItemsDao {
public  void  Addtocart();
	void viewCart();
	int update (int product_id);
	int deletefromcart(int product_id);  
	int generateBill(int product_id);
	
	
	

}
