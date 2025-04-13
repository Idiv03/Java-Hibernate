package com.divya.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.divya.model.Employee;

public class LaunchStdApp {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure()
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Employee employee = new Employee();
	
			employee.setName("Lara");
			employee.setAge(35);
			employee.setCity("WDC");
			
			session.persist(employee);
			
			flag = true;
		
		
		}catch(HibernateException e) {
		e.printStackTrace();
		
		}
		catch(Exception e) {
		e.printStackTrace();
		}finally {
		
		if(flag == true) {
		transaction.commit();
		}else {
		transaction.rollback();
		}
		}
	}
}
		


	
		


