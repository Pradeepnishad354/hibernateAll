package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.test.Employee;

public class CriteriaApiExample {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
	Configuration cfg=new Configuration();
	cfg.configure();
	
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
	Criteria cr= session.createCriteria(Employee.class);
	
	// use filter criteria 
	//fetch the Employee which course only b.tech
//	cr.add(Restrictions.eq("certi.course","b.tech"));
	
	
	// fetch the employee which id is greater than 3
//	cr.add(Restrictions.gt("id",3));
	
	//find the course whic start with b.tech
	cr.add(Restrictions.like("certi.course","b.tech"));
	
	// fetch all the list of the employee
	List<Employee> list = cr.list();
	
	for(Employee emp:list) {
		
		System.out.println(emp);
	}
	
    
		
		
		
		
		
		
	}

}
