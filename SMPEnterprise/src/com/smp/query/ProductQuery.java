package com.smp.query;

public class ProductQuery {
	public static String INSERT_Query="insert into products values(?,?,?,?,?)";
	public static String SELECT_QUERY="select * from products";
		
		public  static String SELECT_SPECIFIC_QUERY="select * from products where product_id=?";
		
		public static String UPDATE_NAME="update products set name=? where product_id=?";
		public static String UPDATE_price="update products set price=? where product_id=?";
		
		
		public static String DELETE_QUERY="delete from products where product_id=?";
		

}
