package com.divya.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divya.model.Student;

public class LaunchFirstApp {

	public static void main(String[] args) {
		//Step 01 Configuration object
		Configuration config = new Configuration();
		
		//Step 2 configure hibernate.cfg.xml file to configuration object
		config.configure();
		
		//Step 3 Create SessionFactory Object
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//Step 4 Get the Session Object from Session Factory
		Session session = sessionFactory.openSession();
		
		//Step 5 Begin the Transaction within Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setsName("Adtiya");
		student.setScity("Patna");
		
		//Step 6 Perform Operation
		session.save(student);
		
		//Step 7 Performing Transaction Operations
		transaction.commit();
		
		//Step 8 Close the session
		session.close();

	}

}
