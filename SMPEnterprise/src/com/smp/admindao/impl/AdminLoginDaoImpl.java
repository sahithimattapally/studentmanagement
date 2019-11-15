package com.smp.admindao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.smp.admin.dao.AdminLoginDao;
import com.smp.query.AdminQuery;
import com.smp.utility.ConnectionManager;

public class AdminLoginDaoImpl implements AdminLoginDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;


	@Override
	public boolean admin(String userName, String password) {
		// TODO Auto-generated method stub
		boolean flag=false;

		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(AdminQuery.ADMIN_QUERY);
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
