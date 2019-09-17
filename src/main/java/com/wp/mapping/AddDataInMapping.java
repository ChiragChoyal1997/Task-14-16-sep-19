package com.wp.mapping;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.dao.DataConnect;
import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Vehicle;

public class AddDataInMapping {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSession();
		
		System.out.println("Add Employee Data");
		System.out.println("Enter employee id");
		int eno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name");
		String ename = sc.nextLine();
		System.out.println("Enter employee salary");
		int sal = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Add laptop id that is to be assigned to employee");
		System.out.println("Enter laptop id");
		String lpid = sc.nextLine();
		System.out.println("Enter laptop brand");
		String lbrand = sc.nextLine();
		System.out.println("Enter laptop price");
		int lprice = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Add vehicle to employee");
		System.out.println("Enter vehicle id");
		String vid = sc.nextLine();
		System.out.println("Enter brand of vehicle");
		String vbrand = sc.nextLine();
		System.out.println("Enter vehicle price");
		int vprice = sc.nextInt();
		
		Transaction tr = session.beginTransaction();
		Laptop l = new Laptop(lpid, lbrand, lprice);
		Vehicle v = new Vehicle(vid, vbrand, vprice);
		Employee e = new Employee(eno, ename, sal, l, v);
		
		session.save(l);
		session.save(v);
		session.save(e);
		tr.commit();
		session.close();
		sc.close();
		System.out.println("Data added succefully !");
	}
}
