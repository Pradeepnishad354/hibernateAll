package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

import com.map.Question;
import com.map2.Emp;
import com.test.Employee;

public class HQLExample {
	
	public static void main(String[] args) {
		
		
		
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
			
	SessionFactory factory=	cfg.buildSessionFactory();
	
Session s=factory.openSession();
	
	String query="from Emp";
//multiple employee

	Query<Emp> q=s.createQuery(query);
	
	List<Emp> list=q.list();
	
	for(Emp e:list) {
		
		System.out.println(e.getName());
	}
	
	
	System.out.println("********************");
	
	
	//delete the query
	Transaction tx=s.beginTransaction();
//Query q2=	s.createQuery("delete from  Emp  e where e.id= :i ");
//
//q2.setParameter("i",10);
//
//int r=q2.executeUpdate();
//System.out.println("delete");
//
//System.out.println(r);

	//update query
//	
//	Query q3=s.createQuery("update Employee set city=:c where name=:n");
//	
//	q3.setParameter("c","Jaunpur");
//	q3.setParameter("n","saurabh");
//	
//int r1=	q3.executeUpdate();
//
//System.out.println(r1+"updated succesfully");
//	
	
	// how to execute join query
	
Query q4=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");

List<Object[]> list2=q4.getResultList();

for(Object[] arr:list2) {
	
	System.out.println(Arrays.toString(arr));
}

	tx.commit();
	s.close();
	factory.close();	
		
	}

}
