package com.sms.dao;

import java.util.List;

import com.sms.bean.Student;

public interface StudentDAO {
	public void addStudent();
	public Student viewStudent(int sno);
	public List<Student> viewAllStudents();
	public void updateStudent(int sno);
	public  void deleteStudent(int sno);

}
