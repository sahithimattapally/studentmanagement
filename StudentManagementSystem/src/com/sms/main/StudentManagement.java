package com.sms.main;

import java.util.List;
import java.util.Scanner;

import com.sms.bean.Student;
import com.sms.daoImpl.StudentDAOImpl;

public class StudentManagement {

	private static final char[] Student = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		StudentDAOImpl dao=new StudentDAOImpl();
		while(true)
		{
			System.out.println("---------------------------");
			System.out.println(" STUDENT MANAGEMENT SYSTEM ");
			System.out.println("---------------------------");
			System.out.println("        1.ADD     STUDENT      ");
			System.out.println("        2.VIEW    STUDENT      ");
			System.out.println("        3.VIEWALL STUDENT      ");
			System.out.println("        4.UPDATE  STUDENT      ");
			System.out.println("        5.DELETE  STUDENT      ");
			System.out.println("        6.EXIT                 ");
			System.out.println("--------------------------      ");
			System.out.println(" Enter your choice ");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				
				dao.addStudent();
				break;
			case 2:
				System.out.println("Enter the Student  Number to be Searched:");
				Student student=dao.viewStudent(sc.nextInt());
				System.out.println("Sno:"+"\t"+"SName:"+ "\t"+"Marks");
				System.out.println(student);
				break;
			case 3:
				List<Student>students=dao.viewAllStudents();
				System.out.println("Sno:"+"\t"+"SName:"+ "\t"+"Marks");
				System.out.println("---------------------------------");
				for (Student s : students)
				{
					System.out.println(s);
				}
				break;
			case 4:
				System.out.println("Enter the StudentNumber to be Searched:");
				dao.updateStudent(sc.nextInt());
				break;
			case 5:
				System.out.println("Enter the Student Number to be Searched:");
				dao.deleteStudent(sc.nextInt());
				break;
			case 6:
				System.exit(0);
				break;
				default:
					System.out.println("Please Select choice range 1-6 only");
				
				
			}
		}
		
		

	}

}
