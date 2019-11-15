package com.smp.admindao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.smp.admin.dao.ProductDao;
import com.smp.bean.Product;
import com.smp.query.ProductQuery;
import com.smp.utility.ConnectionManager;

public class ProductDaoImpl implements ProductDao {
	private Connection con =null;
	private ResultSet rs =null;
private PreparedStatement ps =null;
public List<Product> addrecord=new ArrayList<Product>();


	@Override
	public int addproduct(Product pp) {
		int count = 0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(ProductQuery.INSERT_Query);
			ps.setInt(1,pp.getProduct_id());
			ps.setInt(2,pp.getCat_id());
			ps.setString(3,pp.getName());
			ps.setInt(4,pp.getPrice());
			ps.setInt(5, pp.getQuantity());
			 count=ps.executeUpdate();
				return count;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con,ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count ;
	}

	

	public List<Product> viewallProducts() {
		List<Product> viewallproduct = new ArrayList <Product>();
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(ProductQuery.SELECT_QUERY);
			rs=ps.executeQuery();
			while(rs.next()){
				Product pp= new Product (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				viewallproduct.add(pp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return viewallproduct;
	}

	@Override
	public Product viewproduct(int product_id) {
		Product pd=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(ProductQuery.SELECT_SPECIFIC_QUERY);
			ps.setInt(1, product_id);
			rs=ps.executeQuery();
			while(rs.next())
			{
			pd = new Product (rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pd;
	}

		
		

	

	@Override
	public int updateproduct(int product_id) {
		int count=0;
		try {
			con=	ConnectionManager.getConnection();
Scanner sc=new Scanner(System.in);
System.out.println("Do You Want to Update 1)name 2)price ");
System.out.println("Enter your choice");
int choice=sc.nextInt();

	switch(choice)
	{
	case 1:
		System.out.println("Enter Product Name");
		String cname=sc.next();
		ps=con.prepareStatement(ProductQuery.UPDATE_NAME);
		ps.setString(1,cname);
		ps.setInt(2,product_id);
		count=ps.executeUpdate();
		break;
	case 2:
		System.out.println("Enter product price");
		int price=sc.nextInt();
		ps=con.prepareStatement(ProductQuery.UPDATE_price);
		ps.setInt(1,price);
		ps.setInt(2,product_id);
		count=ps.executeUpdate();
		break;
	default:
		System.out.println("Choose in between 1 to 2");
		
	}

			 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return count;
	}

	

	@Override
	public int deleteproduct(int product_id) {
		int count=0;
		try {
		con=	ConnectionManager.getConnection();
		ps=con.prepareStatement(ProductQuery.DELETE_QUERY);
		ps.setInt(1,product_id);
		count=ps.executeUpdate();
		return count;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				ConnectionManager.release(con, ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;	
		}

	}


