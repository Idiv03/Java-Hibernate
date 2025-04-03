package com.divya.application;

import org.hibernate.cfg.Configuration; 
import jakarta.persistence.EntityExistsException; 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction; 
import org.hibernate.exception.ConstraintViolationException;

import com.divya.model.Student; 
public class LaunchStandardApp { 
   public static void main(String[] args) { 
       Configuration config = null; 
       SessionFactory sessionFactory = null; 
       Session session = null; 
       Transaction transaction = null; 
       boolean flag = false; 
       try { 
           config = new Configuration(); 
           config.configure(); 
           sessionFactory = config.buildSessionFactory(); 
           session = sessionFactory.openSession(); 
           Student student = new Student(); 
           student.setSid(134); 
           student.setsName("Arjun"); 
           student.setScity("Ballia"); 
           transaction = session.beginTransaction(); 
           session.persist(student); 
           transaction.commit(); 
           System.out.println("Transaction commited Succesfully"); 
           flag = true; 
       } catch (EntityExistsException e) { 
           System.out.println("Entity already exists: " + e.getMessage()); 
       } catch (ConstraintViolationException e) { 
           System.out.println("Constraint violation: " + e.getMessage()); 
       } catch (HibernateException e) { 
           System.out.println("Hibernate exception: " + e.getMessage()); 
       } catch (Exception e) { 
           System.out.println("Unexpected exception: " + e.getMessage()); 
       } finally { 
        if(!flag) 
          { 
               if (transaction != null) { 
                   transaction.rollback(); 
                   System.out.println("Transaction rolled back successfully"); 
               } 
           } 
           if (session != null) { 
               session.close(); 
           } 
           if (sessionFactory != null) { 
               sessionFactory.close(); 
           } 
       } 
   } 
} 