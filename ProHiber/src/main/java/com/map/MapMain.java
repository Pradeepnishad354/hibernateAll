package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapMain {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg=new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Question  q1=new Question();
		
		q1.setQuestionId(12);
		q1.setQuestion("what is hibernate ");
		
		
		
		
//		Question  q2=new Question();
//		q2.setQuestionId(22);
//		q2.setQuestion("what is collection ");
		
		
		
//		Answer a1=new Answer();
//		a1.setAnswerId(332);
//		a1.setAnswer("hibernate is a framework of java");
//		a1.setQuestion(q1);
//		
//		Answer a2=new Answer();
//		a2.setAnswerId(333);
//		a2.setAnswer("hibernate is used for mapped the java object");
//		a2.setQuestion(q1);
//		
//		Answer a3=new Answer();
//		a3.setAnswerId(334);
//		a3.setAnswer("it is also used for many relationship");
//		a3.setQuestion(q1);
//		
//		List<Answer> list=new ArrayList<Answer>();
//		
//		list.add(a1);
//		list.add(a2);
//		list.add(a3);
//		q1.setAnswers(list);
//		
//		
		
		//session
	Session s=factory.openSession();
	
Transaction tr=	s.beginTransaction();
	// save
	
//s.save(q1);
//s.save(a1);
//s.save(a2);
//s.save(a3);

//fetch the data

Question q=s.get(Question.class, 12);

System.out.println(q.getQuestionId());

System.out.println(q.getQuestion());
//Eager
//System.out.println(q.getAnswers());

//lazy fetch
//System.out.println(q.getAnswers().size());

//for(Answer a : q.getAnswers()) {
//	
//	System.out.println(a.getAnswer());
//}
//	


	tr.commit();
		
   s.close();
  factory.close();	
		
		
	}

}
