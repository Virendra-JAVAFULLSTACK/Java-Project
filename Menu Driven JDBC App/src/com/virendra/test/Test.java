package com.virendra.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.virendra.beans.Student;
import com.virendra.factory.StudentServiceFactory;
import com.virendra.service.StudentService;

public class Test {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.println("=========================================");
				System.out.println("1. ADD");
				System.out.println("2. SEARCH");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Your Option[1,2,3,4,5] : ");
				int option = Integer.parseInt(br.readLine());
				String sid = "", sname = "", saddr = "";
				StudentService studentService = StudentServiceFactory.getStudentservice();
				Student std = null;
				switch(option) {
				case 1:
					System.out.println("=========================================");
					System.out.print("Student Id	: ");
					 sid = br.readLine();
					System.out.print("Student Name	: ");
					 sname = br.readLine();
					System.out.print("Student Address	: ");
					saddr = br.readLine();
					 std = new Student();
					std.setSid(sid);
					std.setSname(sname);
					std.setSaddr(saddr);
					
					
					String status = studentService.addStudent(std);
					System.out.println("status : "+status);
					break;
				case 2:
					System.out.print("Student Id	: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std == null) {
						System.out.println("Status : Student Not Existed");
					}else {
						System.out.println("Student Details");
						System.out.println("----------------------------------");
						System.out.println("Student Id	: "+std.getSid());
						System.out.println("Student Name	: "+std.getSname());
						System.out.println("Student Address	: "+std.getSaddr());
					}
					break;
				case 3:
					System.out.print("Student ID  : ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std == null) {
						System.out.println("Status : Student Not Existed");
					}else {
						System.out.print("Student Name [Old Name : "+std.getSname()+"] : ");
						String sname_New = br.readLine();
						if(sname_New == null || sname_New.equals("")) {
							sname_New = std.getSname(); 
						}
						System.out.print("Student Address [Old Address : "+std.getSaddr()+"] : ");
						String saddr_New = br.readLine();
						if(saddr_New == null || saddr_New.equals("")) {
							saddr_New = std.getSaddr(); 
						}
						Student std_New = new Student();
						std_New.setSid(sid);
						std_New.setSname(sname_New);
						std_New.setSaddr(saddr_New);
						status =studentService.updateStudent(std_New);
						System.out.println("Status  : "+status);
					}
					break;
				case 4:
					System.out.print("Student Id	: ");
					sid = br.readLine();
					std = studentService.searchStudent(sid);
					if(std == null) {
						System.out.println("Status : Student Not Existed. ");
					}else {
						status = studentService.deleteStudent(sid);
						System.out.println("Status: "+status);
					}
					break;
				case 5:
					System.out.println("***********Thank you for using Student application*************** ");
					System.exit(0);
					break;
				default:
					System.out.println("Provide number from 1,2,3,4,5");
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
