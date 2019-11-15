package com.smp.menu;

import java.util.Scanner;

import com.smp.admindao.impl.AdminLoginDaoImpl;
import com.smp.userDao.Impl.UregisterDaoImpl;

public class AdminMenu {
	static Scanner sc =new Scanner(System.in);
	static AdminLoginDaoImpl al=new AdminLoginDaoImpl();
	public static void Adminloginmenu(){
		while(true)
		{
		
			System.out.println("|==================================|");
			System.out.println("|       ADMIN LOGIN MENU           |");
			System.out.println("|==================================|");
			System.out.println("|         1)LOGIN                  |");
			System.out.println("|         2)BACK                   |");
			System.out.println("|==================================|");
			System.out.println("|------ENTER YOUR CHOICE-----------|");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("ENTER USERNAME");
				String name=sc.next();
				while(!name.matches("[a-z][a-z]*"))
				{
				System.err.println("enter a valid UserName");
				name=sc.next();
				System.out.println(name);
				}
				System.out.println("ENTER PASSWORD");
				String pwd=sc.next();
				while(!pwd.matches("[a-z][a-zA-Z0-9]*"))
				{
				System.err.println("enter Password");
				pwd=sc.next();
				System.out.println(pwd);
				}
				boolean flag=al.admin(name, pwd);
				
				if(flag)
				{
					System.out.println("Login Successful");
				
					SmpMenu.adminMenu();
					
				}

				else
				{
					System.out.println("Invalid or register");
				}
				break;
			case 2:
				break;
		
				
			}
	
}
	}
}
	 
