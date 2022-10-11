package com.pagination;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.test.Employee;

public class HQlPagination {
	
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		
		cfg.configure();
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session s= factory.openSession();
		
		Query query=
				s.createQuery("from Employee");
		
		query.setFirstResult(0);
		
		query.setMaxResults(5);
		
		List<Employee> list =query.list();
		
		for(Employee st:list) {
			
			System.out.println(st.getId()+":"+st.getName()+":"+st.getCity());
		}
		
		s.close();
		factory.close();
		
	}

}
