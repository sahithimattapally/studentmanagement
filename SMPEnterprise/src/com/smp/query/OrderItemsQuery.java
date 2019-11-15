package com.smp.query;

public interface OrderItemsQuery {
	String INSERT_QUERY="insert into productd values(?,?,?,?)";
	String SELECT_QUERY="select * from productd";
	String UPDATE_QUERY="update productd set qty=? where product_id=?";

	 String DELETE_QUERY="delete from productd where product_id=?";
	 
	 String BILL_QUERY= "select product_id,qty,price from productd";
	 String SELECT_QUERY1="select p.quantity,d.qty from products p ,productd d where p.product_id=d.product_id";
	 String UPDATE_QUERY2="update products set quantity=? where product_id=?";

	 String SELECT_QUERY3="select p.product_id,p.quantity from products p";

}
