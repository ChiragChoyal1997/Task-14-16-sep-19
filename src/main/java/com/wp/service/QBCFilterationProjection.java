package com.wp.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.wp.dao.DataConnect;
import com.wp.model.Emp;

public class QBCFilterationProjection {
	public static void main(String args[]) {
		Session session = DataConnect.getSession();
		Criteria cr = session.createCriteria(Emp.class);
		ProjectionList plist = Projections.projectionList();
		
		//this are the fields of entity class which we are going to fetch from database.
		Projection p1 = Projections.property("ename");
		Projection p2 = Projections.property("sal");
		plist.add(p1);
		plist.add(p2);
		
		cr.setProjection(plist);
		
		//Object array is taken beacuse we cannot cast list to Emp(entity). if we do then eno will get null.
		List<Object[]> list = cr.list();
		
		for(Object o[]:list) {
			for(Object s:o) {
				System.out.print(s);
			}
			System.out.println();
		}
		session.close();
	}

}
