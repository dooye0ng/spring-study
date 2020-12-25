package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new Student obj");
            Student tempStudent1 = new Student("Paul","Wall","paul@test.com");
            Student tempStudent2 = new Student("Mary","Pal","wan@test.com");
            Student tempStudent3 = new Student("Oang","Den","den@test.com");
            session.beginTransaction();

            System.out.println("Saving the student ... ");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("Saved !");

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
