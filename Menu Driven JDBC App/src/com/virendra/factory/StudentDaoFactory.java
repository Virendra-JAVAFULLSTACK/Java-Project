package com.virendra.factory;

import com.virendra.dao.StudentDao;
import com.virendra.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao;
	static {
		studentDao = new StudentDaoImpl();
	}
	public static StudentDao getStudentDao() {
		return studentDao;
		
	}
}
