package com.smp.query;

public interface Uregister_Query {
	public static String INSERT_Query="insert into customer values(?,?,?,?,?,?,?,?,?,?,?)";
	public static String SELECT_QUERY="select * from customer where userName=? and password=?";

}
