package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class UpdateStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("UPDATE DEMO");
            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student s set s.firstName = 'dura' where s.id = 3 ")
                    .executeUpdate();

            session.createQuery("update Student s set s.email='TEST@test.com'")
                    .executeUpdate();

            session.getTransaction().commit();


        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> students) {
        for(Student s : students){
            System.out.println(s);
        }
    }

}
