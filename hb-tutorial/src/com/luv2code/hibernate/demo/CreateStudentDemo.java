package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new Student obj");

            Student tempStudent = new Student("Paul","Wall","paul@test.com");
            session.beginTransaction();

            System.out.println("Saving the student ... ");

            session.save(tempStudent);
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
