package com.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	
	public static void main(String[] args) {
		
		
		
		Configuration cf=new Configuration();
		cf.configure("hibernate.cfg.xml");
		
		org.hibernate.SessionFactory factory= cf.buildSessionFactory();
		Session session=factory.openSession();
		
		// get() method 
//		Employee employee=session.get(Employee.class, 11);
//		
//		System.out.println(employee);
		
		Employee employee1=session.load(Employee.class, 11);
		System.out.println(employee1);
		
		Address ad=session.get(Address.class, 1);
		
		System.out.println(ad.getCity()+" "+ad.getStreet());
		
Address ad1=session.get(Address.class, 1);
		
		System.out.println(ad1.getCity()+" "+ad1.getStreet());
		session.close();
		factory.close();
		
		
	}

}
