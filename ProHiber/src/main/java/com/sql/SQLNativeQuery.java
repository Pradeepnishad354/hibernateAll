package com.sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.test.Employee;

public class SQLNativeQuery {
	
	public static void main(String[] args) {
		
		
		
		
		Configuration cfg=new Configuration();
		
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		//SqL query or Native query
		String q="select *from Employee";
		
		NativeQuery query = session.createSQLQuery(q);
		
		List<Object[]> list = query.list();
		
		for(Object[] emp:list) {
			
//			System.out.println(Arrays.toString(emp));
			
			System.out.println("*****************");
			System.out.println(emp[2]+":"+emp[1]);
			
		}
		
		
		session.close();
		
		factory.close();
		
		
	}

}
