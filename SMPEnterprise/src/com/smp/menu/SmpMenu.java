package com.smp.menu;

import java.util.List;
import java.util.Scanner;

import com.smp.admindao.impl.CustomerDaoImpl;
import com.smp.admindao.impl.ProductDaoImpl;
import com.smp.bean.Customer;
import com.smp.bean.Product;
import com.smp.userDao.Impl.OrderItemsDaoImpl;
import com.smp.userDao.Impl.UProductDaoImpl;

public class SmpMenu {
	static Scanner sc=new Scanner(System.in);
	static OrderItemsDaoImpl dao=new OrderItemsDaoImpl();
	static ProductDaoImpl pr=new ProductDaoImpl();
	static UProductDaoImpl udao=new UProductDaoImpl();
	static CustomerDaoImpl cdao=new CustomerDaoImpl();
	public static void adminMenu()
	{
		
		System.out.println("---------------------------");
		System.out.println("|    ADMIN MAIN MENU      |");
		System.out.println("---------------------------");
		System.out.println("|   1. PRODUCT            |");
		System.out.println("|   2. CUSTOMER           |");
		System.out.println("|   3. ORDERS             |");
		System.out.println("|   4. BACK               |");
		System.out.println("--------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) 
		{
		case 1:
			SmpMenu.productMenu();
			break;
		case 2:
			SmpMenu.customerMenu();
			break;
		case 4:
		
			break;

		
		}
		
		}	
		
	
	public static void userMenu()
	{
		
		System.out.println("-----------------------------");
		System.out.println("|    USER MAIN MENU         |");
		System.out.println("-----------------------------");
		System.out.println("|   1. PRODUCT              |");
		System.out.println("|   2. ORDERITEMS           |");
		System.out.println("|   3. BACK                 |");
		System.out.println("-----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) 
		{
		case 1:
			SmpMenu.UproductMenu();
			break;
		case 2:
			SmpMenu.orderitemsMenu();
			break;
		case 3:
	RegisterMenu.loginmenu();	
	
			break;

	}
		}

	static void productMenu()
	{
		System.out.println("---------------------------------");
		System.out.println("|    PRODUCT MENU               |");
		System.out.println("-------------------------------- ");
		System.out.println("|   1. ADD PRODUCT              |");
		System.out.println("|   2. VIEW ALL PRODUCT         |");
		System.out.println("|   3. VIEW PRODUCT             |");
		System.out.println("|   4. UPDATE PRODUCT           |");
		System.out.println("|   5. DELETE PRODUCT           |");
		System.out.println("|   6. BACK                     |");
		System.out.println("---------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Product ID");
			
			String product =sc.next();
			while(!product.matches("[0-9]*"))
			{
			System.err.println("enter a valid id ");
			product=sc.next();
			System.out.println(product);
}
			int  product_id=Integer.parseInt(product);
			System.out.println("Enter Category id");
			
			String cat =sc.next();
			while(!cat.matches("[0-9]*"))
			{
			System.err.println("enter a valid id ");
			cat=sc.next();
			System.out.println(cat);
}
			int  cat_id=Integer.parseInt(cat);
			System.out.println("Enter Product Name");
			String name=sc.next();
			while(!name.matches("[A-Z][a-zA-Z]*"))
			{
			System.err.println("enter a valid Product Name");
			name=sc.next();
			System.out.println(name);
			}
			System.out.println("Enter product Price");
			
			String price_id =sc.next();
			while(!price_id.matches("[0-9]{5}"))
			{
			System.err.println("enter a valid price ");
			price_id=sc.next();
			System.out.println(price_id);
}
			int  price=Integer.parseInt(price_id);
			System.out.println("Enter Product Quantity:");
			String quan_id =sc.next();
			while(!quan_id.matches("[0-9]*"))
			{
			System.err.println("enter a valid quantity ");
			quan_id=sc.next();
			System.out.println(quan_id);
}
			int  quantity=Integer.parseInt(quan_id);
			Product pp=new Product(product_id,cat_id,name,price,quantity);
			int count=pr.addproduct(pp);
			if(count!=0)
				System.out.println("Data inserted");
			else
				System.out.println("Data not inserted");
			break;
		case 2:
			List<Product>viewProduct=pr.viewallProducts();
			for(Product p:viewProduct)
			{
				System.out.println(p.getProduct_id()+"\t"+p.getCat_id()+"\t"+p.getName()+"\t"+p.getPrice()+"\t"+p.getQuantity());
			}
			break;
		case 3:
			System.out.println("Enter Product Id");
			int no =sc.nextInt();
		 Product c=	pr.viewproduct(no);
		 if(c!=null)
				System.out.println(c.getProduct_id()+"\t"+c.getCat_id()+"\t"+c.getName()+"\t"+c.getPrice()+"\t"+c.getQuantity());

		 else
			 System.out.println("data is not found");
		break;
		case 4:
			System.out.println("Enter Product Id");
			int uno=sc.nextInt();
		int ucount=pr.updateproduct(uno);
			if(ucount!=0)
				System.out.println("Updated Successfully");
			else
				System.out.println("Not Updated");
			break;
		case 5:
			System.out.println("Enter Product Id");
			int dno=sc.nextInt();
			int dcount=pr.deleteproduct(dno);
			if(dcount!=0)
				System.out.println("Product deleted");
			else
				System.out.println("Product not deleted");
			break;
		case 6:
			SmpMenu.adminMenu();
			
			break;
			
	
		}
	}
	static void customerMenu()
	{
		System.out.println("----------------------------------");
		System.out.println("|    CUSTOMER MENU               |");
		System.out.println("---------------------------- -----");
		System.out.println("|   1. VIEW ALL CUSTOMER         |");
		System.out.println("|   2. VIEW   CUSTOMER           |");
		System.out.println("|   3. BACK                      |");
		System.out.println("----------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			cdao.viewallcustomers();
			break;
		case 2:
			System.out.println("Enter Customer_id");
			int cno=sc.nextInt();
			Customer cs=cdao.viewcustomer(cno);
			if(cs!=null)
				System.out.println(cs.getCustomer_id()+"\t"+cs.getForename()+"\t"+cs.getSurname()+"\t"+cs.getAdd1()+"\t"+cs.getAdd2()+"\t"+cs.getAdd3()+"\t"+cs.getPost_code()+"\t"+cs.getPhone()+"\t"+cs.getEmail());
				else
					System.out.println("Record not founded");
					break;
		case 3:
			SmpMenu.adminMenu();
			break;
		
			
}

	}
	void orderMenu()
	{
		System.out.println("-----------------------------");
		System.out.println("|    ORDER MENU            |");
		System.out.println("---------------------------- ");
		System.out.println("|   1. VIEW ALL ORDER     |");
		System.out.println("|   2. VIEW  ORDER       |");
		System.out.println("|   3. BACK                 |");
		System.out.println("-----------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
	}
	
	}
	static void  orderitemsMenu()
	{
		
		System.out.println("-------------------------------");
		System.out.println("|    ORDERITEMS MENU          |");
		System.out.println("------------------------------ ");
		System.out.println("|   1. ADD TO CART            |");
		System.out.println("|   2. VIEW CART              |");
		System.out.println("|   3. UPDATE                 |");
		System.out.println("|   4. DELETE FROM CART       |");
		System.out.println("|   5. BILL GENERATION        |");
		System.out.println("|   6. BACK                   |");
		System.out.println("-------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
	
		case 1:
			dao.Addtocart();
		//	System.out.println();
			break;
		case 2:
			dao.viewCart();
			break;
		case 3:
			System.out.println("Enter Product id");
			int num=sc.nextInt();
			dao.update(num);
			break;
		case 4:
			System.out.println("Enter Product id");
			int del=sc.nextInt();
			 int count=dao.deletefromcart(del);
			
			if(count!=0)
				System.out.println(" Record Deleted");
			else
				System.out.println(" Record Not deleted");
			break;
		case 5:
			System.out.println("Enter Product Id");
			int ch=sc.nextInt();
			dao.generateBill(ch);
			default:
				System.out.println("Enter from 1 to 5");

			break;
			case 6:
				SmpMenu.userMenu();
				break;
				
		
			
			
			
		}	
	}
	
	
	
	
	static void UproductMenu()
	{
		
		System.out.println("------------------------------------");
		System.out.println("|    USER PRODUCT MENU             |");
		System.out.println("------------------------------------");
		System.out.println("|   1. VIEW PRODUCT                |");
		System.out.println("|   2. VIEW  ALL PRODUCT           |");
		System.out.println("|   3. BACK                        |");
		System.out.println("------------------------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the product_id");
			
			int no =sc.nextInt();
		 Product c=udao.viewProduct(no);
		 if(c!=null)
				System.out.println(c.getProduct_id()+"\t"+c.getCat_id()+"\t"+c.getName()+"\t"+c.getPrice()+"\t"+c.getQuantity());

		 else
			 System.out.println("data is not found");
			break;
		case 2:
			udao.viewAllProduct();
			break;
		case 3:
			SmpMenu.userMenu();
			break;
	}
	
	
	}
}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

