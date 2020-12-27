package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class ReadStudentDemo {
    public static void main(String[] args) {

        // Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating new Student obj");

            Student tempStudent = new Student("Dori","Pan","doripan@test.com");
            session.beginTransaction();

            System.out.println("Saving the student ... ");
            System.out.println(tempStudent);
            session.save(tempStudent);
            session.getTransaction().commit();

            System.out.println("Saved student Generated id : " + tempStudent.getId());


            // NEW CODE

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Getting Student with id ... ");

            List<Student> students1 = session.createQuery("from Student s where s.lastName = 'wall'",
                    Student.class).getResultList();
            List<Student> students2 = session.createQuery("from Student s where s.email like '%@%'", Student.class)
                    .getResultList();

            System.out.println("======================");
            displayStudents(students1);
            displayStudents(students2);

            session.getTransaction().commit();
            System.out.println("Done !!!");
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
