package com.smp.userDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smp.bean.Uregister;
import com.smp.query.Uregister_Query;
import com.smp.utility.ConnectionManager;

public class UregisterDaoImpl {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	public int register(Uregister ar) {
		int count = 0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(Uregister_Query.INSERT_Query);
			ps.setInt(1, ar.getCustomer_id());
			ps.setString(2, ar.getForename());
			ps.setString(3, ar.getSurname());
			ps.setString(4, ar.getAdd1());
			ps.setString(5, ar.getAdd2());
			ps.setString(6, ar.getAdd3());
			ps.setInt(7, ar.getPost_code());
			ps.setLong(8, ar.getPhone());
			ps.setString(9, ar.getEmail());
			ps.setString(10, ar.getUsername());
			ps.setString(11, ar.getPassword());
			count=ps.executeUpdate();
			if(count!=0)
			{
				System.out.println("user registered");
			}
			else{
				System.out.println("user not registered");
			}
				
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	public boolean login(String userName, String password) {
		
		boolean flag=false;
		// TODO Auto-generated method stub
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(Uregister_Query.SELECT_QUERY);
			ps.setString(1, userName);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}



