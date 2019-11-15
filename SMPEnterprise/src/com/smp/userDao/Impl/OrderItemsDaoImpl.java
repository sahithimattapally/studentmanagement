package com.smp.userDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.smp.admindao.impl.ProductDaoImpl;
import com.smp.bean.Product;
import com.smp.query.OrderItemsQuery;
import com.smp.user.dao.OrderItemsDao;
import com.smp.utility.ConnectionManager;

public class OrderItemsDaoImpl implements  OrderItemsDao {
	Scanner sc = new Scanner(System.in);
//	private static final int Product_id = 0;
	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	PreparedStatement ps2=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	ProductDaoImpl ad=new ProductDaoImpl();
//	static List<Product> temp=new ArrayList<Product>();
	

	@Override
	public void Addtocart() {
		List<Product> viewProducts=		ad.viewallProducts();
		try {
			con=ConnectionManager.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Product pd : viewProducts)
		{
			System.out.println(pd.getProduct_id()+"\t"+pd.getName()+"\t"+pd.getPrice()+"\t"+pd.getQuantity());
		

		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Which product u want to buy");
		int pid=sc.nextInt();
		System.out.println("Enter the quantity");
		int qty1=sc.nextInt();
		
		for(Product pd : viewProducts)
		{
if(pd.getProduct_id()==pid)
{
	try {
		ps=con.prepareStatement(OrderItemsQuery.INSERT_QUERY);
		ps.setInt(1,pd.getProduct_id());
		ps.setString(2, pd.getName());
		
		ps.setInt(3, pd.getPrice());
		ps.setInt(4, qty1);

	int count=	ps.executeUpdate();
	if(count!=0)
System.out.println("Added to cart succcessfully");
	else
		System.out.println("Not added");
		
	} catch (SQLException e) {
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

}
		}
		
		
}

	@Override
	public void viewCart() {
		// TODO Auto-generated method stub
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(OrderItemsQuery.SELECT_QUERY);
rs=ps.executeQuery();
while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		finally
		{
			try {
				ConnectionManager.release(con, ps,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	}
	

	@Override
	public int update(int Product_id) {
		// TODO Auto-generated method stub
		int count = 0;
		
		
		try {
			System.out.println("Enter Quantity");
			int qty=sc.nextInt();
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(OrderItemsQuery.UPDATE_QUERY);
			
			
			//ps=con.prepareStatement(StudentQueryConstants.UPDATE_NAME);
			ps.setInt(1, qty);
			ps.setInt(2, Product_id);
			count=ps.executeUpdate();
			if(count!=0){
				System.out.println("Quantity updated");
				
			}
			else{
				System.out.println("Quantity not updated");
				
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
	public int deletefromcart(int Product_id) {
		int count =0;
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(OrderItemsQuery.DELETE_QUERY);
			ps.setInt(1, Product_id);
			count=ps.executeUpdate();
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

	
	public int generateBill(int product_id) {
		int total=0;
		
		try {
			con=ConnectionManager.getConnection();
			ps=con.prepareStatement(OrderItemsQuery.BILL_QUERY);
			rs=ps.executeQuery();
			int pida=0;
			int qty=0;
			while(rs.next()){
						System.out.println("QUANTITY"+"\t"+"\t"+"PRICE");
						 pida=rs.getInt(1);
						 qty=rs.getInt(2);
						System.out.println(rs.getInt(2)+"\t"+"\t"+"\t"+rs.getInt(3));
			
					total=rs.getInt(2)*rs.getInt(3);
					System.out.println("Total :"+total);
				
			}
			
						ps1=con.prepareStatement(OrderItemsQuery.SELECT_QUERY3);
						rs1=ps1.executeQuery();
						while(rs1.next()){
							//System.out.println("QUANTITY"+"\t"+"\t"+"qty");
							//System.out.println(rs1.getInt(1)+"\t"+"\t"+"\t"+rs1.getInt(2));
							
						int count = rs1.getInt(2)-qty;
						if(rs1.getInt(1)==pida)
						{
						ps2=con.prepareStatement("update products set quantity=? where product_id=?");
						ps2.setInt(1,count);
						ps2.setInt(2,pida);
						ps2.executeUpdate();
						}			
					//	total=rs.getInt(1)*rs.getInt(2);
					//	total=rs.getInt(2)*rs.getInt(3);
						//System.out.println("Total Amount:"+total);

						
						}			}
			//System.out.println("total amount =\t"+"\t"+total);
			
			
			
			
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//int count = quantity-qty;
			
			
			/*ps1=con.prepareStatement(OrderItemsQuery.SELECT_QUERY1);
			rs1=ps1.executeQuery();
			while(rs1.next()){
				System.out.println("QUANTITY"+"\t"+"\t"+"qty");
				System.out.println(rs1.getInt(1)+"\t"+"\t"+"\t"+rs1.getInt(2));
				
				int count = rs1.getInt(1)-rs1.getInt(2);
				System.out.println("updated quantity"+count);

			}
			ps2=con.prepareStatement(OrderItemsQuery.UPDATE_QUERY2);
			//ps2.setInt(1,quantity);
			int up=ps2.executeUpdate();
			if(up!=0){
				System.out.println("Quantity Updated");
				
			}
			else{
				System.out.println("Quantity not updated");
			}
			
		}
			
			
		
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/		return total;
		
	
			}
			
}