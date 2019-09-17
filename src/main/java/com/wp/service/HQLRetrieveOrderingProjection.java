package com.wp.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.wp.dao.DataConnect;

public class HQLRetrieveOrderingProjection {
	public static void main(String args[]) {
		Session session = DataConnect.getSession();
		String hql = "select ename, sal from Emp ORDER BY sal ASC";
		
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		System.out.println("Employees Records using HQL query");
		System.out.println("======================================");
		for(Object o[]:list) {
			for(Object x:o) {
				System.out.print(x+", ");
			}
			System.out.println();
		}
		System.out.println("=======================================");
		session.close();
	}
}
