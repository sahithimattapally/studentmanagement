package com.smp.admindao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smp.admin.dao.CustomerDao;
import com.smp.bean.Customer;
import com.smp.bean.Product;
import com.smp.query.CustomerQuery;
import com.smp.utility.ConnectionManager;

public class CustomerDaoImpl implements CustomerDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	@Override
	public void viewallcustomers() {
		// TODO Auto-generated method stub
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(CustomerQuery.SELECT_QUERY);
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getInt(7)+"\t"+rs.getLong(8)+"\t"+rs.getString(9));
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Customer viewcustomer(int customer_id) {
		// TODO Auto-generated method stub
		Customer c=null;
	
			try {
				con=ConnectionManager.getConnection();
				ps=con.prepareStatement(CustomerQuery.SELECT_SPECIFIC_QUERY);
				ps.setInt(1, customer_id);
				rs=ps.executeQuery();
				while(rs.next())
				{
				c= new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getLong(8),rs.getString(9));
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;

	}

}
