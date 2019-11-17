package com.sms.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sms.bean.Student;
import com.sms.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {
	Scanner sc=new Scanner(System.in);
	Student student=null;
	static List<Student> students=new ArrayList<Student>();
	static List<Student>tempList=new ArrayList<Student>();
	File f=new File("student.txt");
	File f1=new File("tempFile.txt");
	FileInputStream fis=null;
	FileOutputStream fos=null;
	ObjectInputStream ois=null;
	ObjectOutputStream oos=null;
	
	
	
	
	
	

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		try {
			if(!f.exists())
			{
				f.createNewFile();
			}
			int n=1;
			while(n==1)
			{
				student =new Student();
				System.out.println("Enter Student Number");
				student .setSno(sc.nextInt());
				System.out.println("Enter Student Name");
				student .setSname(sc.next());
				System.out.println("Enter Student Marks");
				student.setMarks(sc.nextInt());
				students.add(student);
				System.out.println("do u want to add more students press 1 else  any number");
				n=sc.nextInt();
				
				
				
			}
			fos=new  FileOutputStream(f);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(students);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully Added");
		
		
	}

	@Override
	public Student viewStudent(int sno) {
		// TODO Auto-generated method stub
		Student s1=null;
		try {
			
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			List<Student>students=(List<Student>) ois.readObject();
			for(Student s:students)
			{
				if(s.getSno()==sno)
					s1=s;
				break;
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s1;
		
	
	}

	@Override
	public List<Student> viewAllStudents() {
		List<Student> studentsList=null;
		try {
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			studentsList=(List<Student>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return studentsList;
	}

	@Override
	public void updateStudent(int sno) {
		// TODO Auto-generated method stub
		try {
			students=new ArrayList<Student>();
			List<Student>tempList=new ArrayList<Student>();
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			students=(List<Student>) ois.readObject();
			for(Student ss:students)
			{
				if(ss.getSno()==sno)
				{
					System.out.println("Select 1.Name   2.Marks");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Enter the name to be updated:");
						ss.setSname(sc.next());
						break;
					case 2:
						System.out.println("Enter the Marks to be Updated:");
						ss.setMarks(sc.nextInt());
						break;
						default:
							System.out.println("Please select choice range of 1-2 only");
					
				}
					tempList.add(ss);
				}
				else
				{
					tempList.add(ss);
				}
			}
			List<Student>students=new ArrayList<Student>();
			for(Student s3:tempList)
			{
				students.add(s3);
			}
			fos=new FileOutputStream(f);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(students);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Succesfully Updated");
		
	}

	@Override
	public void deleteStudent(int sno) {
		// TODO Auto-generated method stub
		try {
			students=new ArrayList<Student>();
			List<Student>tempList=new ArrayList<Student>();
			fis  =new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			students=(List<Student>) ois.readObject();
			for(Student ss:students)
			{
				if(ss.getSno()==sno)
				{
				}
				else
				{
					tempList.add(ss);
				}
			}
      List<Student>students=new ArrayList<Student>();
      for(Student s3:tempList)
      {
			   students.add(s3);
      }
      fos=new FileOutputStream(f);
      oos=new ObjectOutputStream(fos);
      oos.writeObject(students);
		} catch (SecurityException | ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully Deleted");
	}

}