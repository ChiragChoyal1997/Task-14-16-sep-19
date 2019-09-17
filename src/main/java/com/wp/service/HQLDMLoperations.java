package com.wp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class HQLDMLoperations {

	public static void main(String args[]) {
		String hql;
		int id;
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while(i<=4) {
			Session session = DataConnect.getSession();
			System.out.println("===========================================");
			System.out.println("Select DML operation you want to perform using HQL");
			System.out.println("-------------------------------------------");
			System.out.println("1. Add Employee");
			System.out.println("2. Retrieve Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.println("===========================================");
			i = sc.nextInt();

			switch (i) {
			case 1:
				Transaction tr2 = session.beginTransaction();
				hql = "INSERT into Emp(eno,ename,sal) select e.eno,e.ename,e.sal from Employee e";
				Query query3 = session.createQuery(hql);
				int l = query3.executeUpdate();
				if(l>0) {
					System.out.println("Record added successfully !");
				}
				else {
					System.out.println("Something went wrong");
				}
				tr2.commit();
				session.close();
				break;
			case 2:
				System.out.println("Enter Employee Id");
				id = sc.nextInt();
				hql = "from Emp where eno=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				List<Emp> list = query.list();

				System.out.println("======================Emloyee Data===================");
				if(list.size()>0) {
					for(Emp e:list) {
						System.out.println(e.toString());
					}
				}
				else {
					System.out.println("Record not found!");
				}
				System.out.println("=====================================================");
				session.close();
				break;

			case 3:
				Transaction tr = session.beginTransaction();
				System.out.println("Which field you want to update");
				System.out.println("1. Employee name");
				System.out.println("2. Employee Salary");
				System.out.println("Enter your choice");
				int choice = sc.nextInt();
				sc.nextLine();
				System.out.println("To update provide employee id");
				id = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.println("New Employee Name");
					String ename = sc.nextLine();
					String hql3 = "update Emp set ename = :ename where eno = :id";
					Query query1 = session.createQuery(hql3);
					query1.setParameter("id", id);
					query1.setParameter("ename", ename);

					int j = query1.executeUpdate();
					if(j>0) {
						System.out.println("Record updated successfully !");
					}
					else {
						System.out.println("Something went wrong/record not found");
					}
					session.flush();
					tr.commit();
					session.close();
					break;
				case 2:
					System.out.println("New salary");
					int sal = sc.nextInt();
					sc.nextLine();
					String hql4 = "update Emp set sal = :sal where eno = :id";
					Query query2 = session.createQuery(hql4);
					query2.setParameter("id", id);
					query2.setParameter("sal", sal);
					int k = query2.executeUpdate();
					if(k>0) {
						System.out.println("Record updated successfully !");
					}
					else {
						System.out.println("Something went wrong/record not found");
					}
					session.flush();
					tr.commit();
					session.close();
					break;

				default:
					break;
				}
				break;
			case 4:
				Transaction tr1 = session.beginTransaction();
				System.out.println("Enter employee id you want to delete");
				id = sc.nextInt();
				sc.nextLine();
				String hql5 = "delete from Emp where eno = :id";
				Query query1 = session.createQuery(hql5);
				query1.setParameter("id", id);
				int j = query1.executeUpdate();
				if(j>0) {
					System.out.println("Record Deleted!");
				}
				else {
					System.out.println("Something went wrong!");
				}
				session.flush();
				tr1.commit();
				session.close();
				break;

			default:
				session.close();
				System.out.println("BYE - BYE");
				break;
			}
		}
		sc.close();
	}
}
