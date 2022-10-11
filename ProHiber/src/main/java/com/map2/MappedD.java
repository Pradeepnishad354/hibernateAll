package com.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappedD {
	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Emp e1=new Emp();
		Emp e2=new Emp();
		Project p1=new Project();
		Project p2=new Project();
		
		e1.setEmpId(11);
		e1.setName("saurah");
		
		e2.setEmpId(10);
		e2.setName("jay");
		
		
		
		p1.setProjectId(24);
		p1.setProjectName("smart COntact Manager");
		
		p2.setProjectId(25);
		
		p2.setProjectName("Mseva");
		
		List<Emp> list1=new ArrayList<Emp>();
		List<Project> list2=new ArrayList<Project>();
		
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		// set emp/pro
		e1.setProjects(list2);
		
		p2.setEmp(list1);
		
	Session s=	factory.openSession();
	
	Transaction tr=s.beginTransaction();
	s.save(e1);
	s.save(e2);
	s.save(p1);
	s.save(p2);
	
	
	tr.commit();
		
		factory.close();
	}

}
