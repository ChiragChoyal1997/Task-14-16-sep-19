package com.wp.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class HQLParametrizedPositionBased {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Provide employee id (Demo of parametrized query)");
		int id = sc.nextInt();
		sc.nextLine();
		Session session = DataConnect.getSession();
		String hql = "from Emp where eno = ?1";
		Query query = session.createQuery(hql);
		query.setParameter(1, id);

		List<Emp> list = query.list();
		if(list.size()>0) {
			for(Emp e : list) {
				System.out.println(e.toString());
			}
		}
		else {
			System.out.println("Employee not found !");
		}
		sc.close();
	}

}
