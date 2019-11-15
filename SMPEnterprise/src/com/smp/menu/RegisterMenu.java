package com.smp.menu;

import java.util.Scanner;

import com.smp.bean.Uregister;
import com.smp.userDao.Impl.UregisterDaoImpl;

public class RegisterMenu {

	

		static Scanner sc =new Scanner(System.in);
		static UregisterDaoImpl sa=new UregisterDaoImpl();
		public static void loginmenu(){
			while(true)
			{
			
				System.out.println("|=============================|");
				System.out.println("|         LOGIN MENU          |");
				System.out.println("|=============================|");
				System.out.println("|         1)REGISTER          |");
				System.out.println("|         2)LOGIN             |");
				System.out.println("|         3)BACK              |");
				System.out.println("|=============================|");
				System.out.println("|------ENTER YOUR CHOICE------|");
				int choice=sc.nextInt();
				switch(choice)
				{
				case 1:
				System.out.println("ENTER CUSTOMER ID");
				String cust_id =sc.next();
				while(!cust_id.matches("[0-9]*"))
				{
				System.err.println("enter a valid id ");
				cust_id=sc.next();
				System.out.println(cust_id);
}
				int  customer_id=Integer.parseInt(cust_id);

				System.out.println("ENTER FORENAME");
				String forename=sc.next();
				while(!forename.matches("[A-Z][a-zA-Z]*"))
				{
				System.err.println("enter a valid  ForeName");
				forename=sc.next();
				System.out.println(forename);
				}
				System.out.println("ENTER SURNAME");
				String surname=sc.next();
				while(!surname.matches("[A-Z][a-zA-Z]*"))
				{
				System.err.println("enter a valid SurName");
				surname=sc.next();
				System.out.println(surname);
				}
				System.out.println("ENTER ADDRESS LINE-1");
				String add1=sc.next();
				while(!add1.matches("[A-Z][0-9a-zA-Z]*"))
				{
				System.err.println("enter a valid address line ");
				add1=sc.next();
				System.out.println(add1);
				}
				System.out.println("ENTER ADDRESS LINE-2");
				String add2=sc.next();
				while(!add2.matches("[A-Z][0-9a-zA-Z]*"))
				{
				System.err.println("enter a valid address ");
				add2=sc.next();
				System.out.println(add2);
				}
				System.out.println("ENTER ADDRESS LINE-3");
				String add3=sc.next();
				while(!add2.matches("[A-Z][0-9a-zA-Z]*"))
				{
				System.err.println("enter a valid address ");
				add3=sc.next();
				System.out.println(add3);
				}
				System.out.println("ENTER POSTCODE");
			
				String post =sc.next();
				while(!post.matches("[0-9]{6}"))
				{
				System.err.println("enter a valid id ");
				post=sc.next();
				System.out.println(post);
                }
				int  post_code=Integer.parseInt(post);
				System.out.println("ENTER MOBILENUMBER");
				
				String phone_no =sc.next();
				while(!phone_no.matches("[7-9][0-9]{9}"))
				{
				System.err.println("enter a valid mobile number ");
				phone_no=sc.next();
				System.out.println(phone_no);
}
				int  phone=Integer.parseInt(phone_no);
				System.out.println("ENTER EMAIL ID");
				String email=sc.next();
				while(!email.matches("[A-Za-z0-9][0-9a-zA-Z.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+"))
				{
				System.err.println("enter a valid email id ");
				email=sc.next();
				System.out.println(email);
				}
				System.out.println("ENTER USERNAME");
				String userName=sc.next();
				while(!userName.matches("[A-Z][0-9a-zA-Z]*"))
				{
				System.err.println("enter a valid username ");
				userName=sc.next();
				System.out.println(userName);
				}
				System.out.println("ENTER PASSWORD");
				String password=sc.next();
				while(!password.matches("[a-zA-Z0-9!@#$%^&*]{6,16}$"))
				{
				System.err.println("enter a valid password ");
				password=sc.next();
				System.out.println(password);
				}
				
				
				Uregister ch=new Uregister(customer_id,forename,surname,add1,add2,add3,post_code,phone,email,userName,password);
				int count=sa.register(ch);
				if(count!=0)
					System.out.println("DATA INSERTED SUCCESSFULLY");
				else
					
					System.out.println("DATA NOT INSERTED SUCCESSFULLY");	
				break;
				case 2:
					
					
					System.out.println("ENTER USERNAME");
					String name=sc.next();
					System.out.println("ENTER PASSWORD");
					String pwd=sc.next();
					boolean flag=sa.login(name, pwd);
					
					if(flag)
					{
						System.out.println("Login Successful");
					
						SmpMenu.userMenu();
						
					}

					else
					{
						System.out.println("Invalid or register");
					}
					
			
				
				break;
				case 3:
					
					
					System.out.println("THANKS FOR USING THE APPLICATION");
				
					break;
				default:
					System.out.println("CHOOSE YOUR CHOICE BETWEEN 1 TO 2");
				
			
			
				}
				}
			}

		
		



}