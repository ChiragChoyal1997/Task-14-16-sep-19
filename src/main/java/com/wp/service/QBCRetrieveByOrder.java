package com.wp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class QBCRetrieveByOrder {
	public static void main(String args[]) {
		Session session  = DataConnect.getSession();
		Criteria cr = session.createCriteria(Emp.class);
		cr.addOrder(Order.asc("sal"));
		
		List<Emp> list = cr.list();
		for(Emp e:list) {
			System.out.println(e.toString());
		}
		session.close();
	}
}
