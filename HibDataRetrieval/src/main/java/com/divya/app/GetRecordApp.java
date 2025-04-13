package com.divya.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.divvya.model.Employee;

public class GetRecordApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().
										addAnnotatedClass(Employee.class).
										buildSessionFactory();
		
		Session session = null;
		try {
			
			 session =sessionFactory.openSession();
			//Employee emp =  session.get(Employee.class, 2);
			//System.out.println(emp);
			// Employee emp = session.get(Employee.class, 2);  // Eagerly loads the object 
			 Employee emp = session.getReference(Employee.class, 2);
	 
			System.out.println("Id id :"+emp.getId());
			
			System.out.println("name id :"+emp.getName());
			
			System.out.println("Age id :"+emp.getAge());
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sessionFactory.close();
			session.close();
		}

	}

}
