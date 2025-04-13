package com.divya.app;
import org.hibernate.cfg.Configuration; 
import jakarta.persistence.EntityExistsException; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.exception.ConstraintViolationException;

import com.divya.model.Student; 
public class LaunchUpdate {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().
				addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
		 session = sessionFactory.openSession();
		 transaction = session.beginTransaction();
		 
		 Student st = new Student();
		 st.setSid(6);
		 st.setsName("AAdi");
		 st.setScity("Patna");
		 
		 //save or update
		 session.merge(st);
		 flag = true;
		 
		 
		}catch(HibernateException e){
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag == true)
				transaction.commit();
			else
				transaction.rollback();
			
			session.close();
			sessionFactory.close();
		}
		
		
		
	}

}
