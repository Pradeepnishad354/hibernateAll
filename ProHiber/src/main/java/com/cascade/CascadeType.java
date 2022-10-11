package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeType {
	
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
	SessionFactory factory=	cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	
	Question q1=new Question();
	q1.setQuestionId(555);
	q1.setQuestion("what is Hql");
	
	
	Answer a1=new Answer();
	
	a1.setAnswerId(48);
	a1.setAnswer("Hql is Hibernate query Language");
	
Answer a2=new Answer();
	
	a2.setAnswerId(49);
	a2.setAnswer("second Answer");
	
		
Answer a3=new Answer();
	
	a3.setAnswerId(50);
	a3.setAnswer("Third answer");
	
	List<Answer> list=new ArrayList<Answer>();
	
	list.add(a1);
	list.add(a2);
	list.add(a3);
	
	q1.setAnswers(list);
	
	Transaction tx = session.beginTransaction();
	
	// by cascade the entity are related to each other and perfrom the operation automatically save,delete.merge 
	
	session.save(q1);
	tx.commit();
	session.close();
	factory.close();
	
	
		
	}

}
