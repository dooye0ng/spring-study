package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg2.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor =
                    new Instructor("Tom", "Machel", "Machel@test.com");
            InstructorDetail instructorDetail1 =
                    new InstructorDetail("Macelyoutube.com", "coding");
            Course course1 =
                    new Course("Python : Ultimate Course");
            Course course2 =
                    new Course("Java : Master from Scratch");

            instructor.setInstructorDetail(instructorDetail1);
            instructor.add(course1);
            instructor.add(course2);

            session.beginTransaction();

            session.persist(instructor);

            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
