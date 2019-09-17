package com.wp.mapping;

import java.util.Scanner;

import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wp.dao.DataConnect;
import com.wp.model.Employee;
import com.wp.model.Vehicle;

public class DeleteDataInMapping {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		Session session = DataConnect.getSession();

		Transaction tr = session.beginTransaction();
		System.out.println("Which record you want to delete");
		System.out.println("1. Employee");
		System.out.println("2. Vehicle");
		System.out.println("3. Laptop");
		System.out.println("Enter choice");
		int choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			System.out.println("Enter employee id");
			int eno = sc.nextInt();
			sc.nextLine();
			Employee e = new Employee();
			e.setEno(eno);
			session.delete(e);
			tr.commit();
			session.close();
			break;

		case 2:
			System.out.println("Enter vehicle id");
			String vno = sc.nextLine(); 
			Query query = session.createSQLQuery("{CALL delete_vehicle_set_null(?1)}");
			query.setString(1, vno);
			query.executeUpdate();
			tr.commit();
			System.out.println("Executed");
			session.close();
			break;
		case 3:
			System.out.println("Enter laptop id");
			String lno = sc.nextLine(); 
			Query query1 = session.createSQLQuery("{CALL delete_laptop_set_null(?1)}");
			query1.setString(1, lno);
			query1.executeUpdate();
			tr.commit();
			System.out.println("Executed");
			session.close();
			break;

		default:
			break;
		}
		sc.close();
	}
}
