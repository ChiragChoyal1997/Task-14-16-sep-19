package com.wp.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

///This is class to add an  employee in database

public class AddEmp {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("To add an employee provide details");
		System.out.println("Employee Id");
		int eno = sc.nextInt();
		sc.nextLine();
		System.out.println("Employee name");
		String ename = sc.nextLine();
		System.out.println("Employee Salary");
		int sal = sc.nextInt();
		
		Emp e = new Emp(eno, ename, sal);
		
		Session session = DataConnect.getSession();
		Transaction tr = session.beginTransaction();
		session.save(e);
		tr.commit();
		session.close();
		sc.close();
		System.out.println("Record added succefully !");
	}
}
