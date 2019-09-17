package com.wp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class QBCRetrieveAllEmp {
	public static void main(String args[]) {
		Session session = DataConnect.getSession();
		Criteria cr = session.createCriteria(Emp.class);
		List<Emp> list = cr.list();
		System.out.println("All employees details");
		for(Emp e: list) {
			System.out.println(e.toString());
		}
		session.close();
	}

}
