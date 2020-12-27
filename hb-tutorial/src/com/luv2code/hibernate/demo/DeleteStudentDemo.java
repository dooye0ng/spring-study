package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DeleteStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Student student = session.get(Student.class, 3);
            session.delete(student);

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
