package com.test;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	
	
	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=	cfg.buildSessionFactory();
	
	
	Employee emp1=new Employee();
	emp1.setId(2);
	emp1.setName("rahul");
	emp1.setCity("Jaunpur");
	
	Employee emp2=new Employee();
	emp2.setId(3);
	emp2.setName("abhi");
	emp2.setCity("Jaunpur");
	
Certificate c=new Certificate();
	c.setCourse("b.tech");
	c.setDuration("4 years");
	emp1.setCerti(c);
	
	Certificate c1=new Certificate();
	c1.setCourse("diploma");
	c1.setDuration("4 years");
	emp2.setCerti(c1);
	
Session s=factory.openSession();
        Transaction tr= s.beginTransaction();

// objetcs are save
s.save(emp1);
s.save(emp2);
tr.commit();



s.close();
factory.close();

		
		
	}

}
