package com.smp.userDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smp.bean.Product;
import com.smp.query.UProductQuery;
import com.smp.user.dao.UProductDao;
import com.smp.utility.ConnectionManager;

public class UProductDaoImpl implements UProductDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	@Override
	public
	Product viewProduct(int Product_id) {
		
		Product pd=null;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(UProductQuery.SELECT_SPECIFIC_QUERY1);
			ps.setInt(1, Product_id);
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
	public void viewAllProduct() {
		// TODO Auto-generated method stub
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(UProductQuery.SELECT_QUERY1);
			rs=ps.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ConnectionManager.release(con, ps, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
		
	}



	

	

