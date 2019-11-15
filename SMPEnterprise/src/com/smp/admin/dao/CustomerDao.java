package com.smp.admin.dao;

import com.smp.bean.Customer;

public interface CustomerDao {
	void viewallcustomers();
	Customer viewcustomer(int customer_id);

}
