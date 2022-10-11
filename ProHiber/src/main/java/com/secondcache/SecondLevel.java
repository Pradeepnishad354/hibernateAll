package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.Employee;

public class SecondLevel {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		// second level cache * in which can e use multiple session to fetch the object
		
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Employee employee = session.get(Employee.class,2);
		
		System.out.println(employee);
		
		session.close();
		
		Session session2 = factory.openSession();
		
       Employee employee1 = session2.get(Employee.class,2);
		
		System.out.println(employee1);
		
		session2.close();
		
		
		
	}

}
