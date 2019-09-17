package com.wp.mapping;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.dao.DataConnect;
import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Vehicle;

public class RetrieveDataMapping {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Fetch record of.....");
		System.out.println("1. Employee");
		System.out.println("2. Vehicle");
		System.out.println("3. Laptop");
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.println("Enter Employee Id to update data");
			int eno = sc.nextInt();
			sc.nextLine();
			Employee e = session.get(Employee.class, eno);
			System.out.println(e.toString());
			tr.commit();
			session.close();
			break;
		case 2:
			System.out.println("Enter vehicle Id to update data");
			String vid = sc.nextLine();
			Vehicle v = session.get(Vehicle.class, vid);
			System.out.println(v.toString());
			tr.commit();
			session.close();
			break;
		case 3:
			System.out.println("Enter laptop Id to update data");
			String lid = sc.nextLine();
			Laptop l = session.get(Laptop.class, lid);
			System.out.println(l.toString());
			tr.commit();
			session.close();
			break;

		default:
			System.out.println("Bye-Bye");
			break;
		}
		sc.close();
	}
}
