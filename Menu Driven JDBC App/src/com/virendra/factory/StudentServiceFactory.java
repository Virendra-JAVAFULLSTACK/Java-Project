package com.virendra.factory;

import com.virendra.service.StudentService;
import com.virendra.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	static {
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentservice(){
		return studentService;
		
	}
}
