package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.Employee;

public class FirstCache {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		
		cfg.configure();
		
	SessionFactory factory=	cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	
	Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
		
		Employee employee2 = session.get(Employee.class, 1);
		
		System.out.println(employee2);
		
		System.out.println(session.contains(employee2));
		
		session.close();
		
		factory.close();
	}

}
