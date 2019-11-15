package com.smp.Client;

import java.util.Scanner;

import com.smp.menu.AdminMenu;
import com.smp.menu.RegisterMenu;
import com.smp.menu.SmpMenu;

public class SMPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("------------------------------------------");
			System.out.println("           SMP ENTERPRISE                 ");
			System.out.println("------------------------------------------");
			System.out.println("           1.ADMIN                        ");
			System.out.println("           2.USER                         ");
			System.out.println("           3.BACK                         ");
			System.out.println("------------------------------------------");
			System.out.println("Enter your choice");
			int choice=0;
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
		   AdminMenu.Adminloginmenu();
			break;
			case 2:
				RegisterMenu.loginmenu();
				break;
			case 3:
				System.exit(0);
				break;
				

	

}
	}
}
}