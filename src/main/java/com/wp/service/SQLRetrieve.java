package com.wp.service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class SQLRetrieve {
	public static void main(String args[]) {
		Session session = DataConnect.getSession();
		
		String sql = "select * from emp";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Emp.class);
		
		List<Emp> list = query.list();
		
		if(list.size()>0) {
		for(Emp e:list) {
			System.out.println(e.toString());
		}
		}
		else {
			System.out.println("No data found !");
		}
		session.close();
	}

}
