package com.wp.mapping;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wp.dao.DataConnect;
import com.wp.model.Employee;
import com.wp.model.Laptop;
import com.wp.model.Vehicle;

public class UpdateInMapping {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSession();
		Transaction tr = session.beginTransaction();
		System.out.println("Update choices");
		System.out.println("1. Employee");
		System.out.println("2. Vehicle");
		System.out.println("3. Laptop");
		System.out.println("your choice");
		int choice = sc.nextInt();
		sc.nextLine();
		switch (choice) {
		case 1:
			System.out.println("Enter Employee Id to update data");
			int eno = sc.nextInt();
			sc.nextLine();
			Employee e = session.get(Employee.class, eno);
			System.out.println("Enter ename");
			String ename = sc.nextLine();
			System.out.println("Enter salary");
			int sal = sc.nextInt();
			e.setEname(ename);
			e.setSal(sal);
			session.update(e);
			tr.commit();
			session.close();
			System.out.println("Employee record updated");
			break;
		case 2:
			System.out.println("Enter vehicle Id to update data");
			String vid = sc.nextLine();
			Vehicle v = session.get(Vehicle.class, vid);
			System.out.println("Enter brand of vehicle");
			String brand = sc.nextLine();
			System.out.println("Enter price of vehicle");
			int price = sc.nextInt();
			v.setBrand(brand);
			v.setPrice(price);
			session.update(v);
			tr.commit();
			session.close();
			System.out.println("Vehicle record updated");
			break;
		case 3:
			System.out.println("Enter laptop Id to update data");
			String lid = sc.nextLine();
			Laptop l = session.get(Laptop.class, lid);
			System.out.println("Enter brand of laptop");
			String lbrand = sc.nextLine();
			System.out.println("Enter price of laptop");
			int lprice = sc.nextInt();
			l.setBrand(lbrand);
			l.setPrice(lprice);
			session.update(l);
			tr.commit();
			session.close();
			System.out.println("Laptop record updated");
			break;
		default:
			System.out.println("Bye-Bye");
			break;
		}
		sc.close();
	}
}
