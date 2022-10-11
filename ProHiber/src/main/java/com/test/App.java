package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, IOException
    {
        System.out.println( "Started" );
        
        
        Configuration cfg=new Configuration();
        
        cfg.configure("hibernate.cfg.xml");
        
        
        SessionFactory factory=cfg.buildSessionFactory();
        
        
        Employee emp=new Employee();
        
        emp.setId(11);
        emp.setName("saurabh");
        emp.setCity("varanasi");
        
        Address ad=new Address();
        ad.setStreet("Varanasi");
        ad.setCity("sigra");
        ad.setOpen(true);
        ad.setDate(new Date());
        ad.setX(12344.49);
        
        // read the image
        FileInputStream fil=new FileInputStream("src/main/java/p1.png");
        
        byte[] data=new byte[fil.available()]; 
        
        fil.read(data);
        ad.setImage(data);
        
        
      
        Session session = factory.openSession();
       
       
     org.hibernate.Transaction tr= session.beginTransaction();
      
      session.save(emp);
     session.save(ad);
       tr.commit(); 
      session.close();
      System.out.println("done.......");
      
      
      
      
      
        
        
        
       
        
    }
   
    
}
