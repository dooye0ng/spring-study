package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("daem", "pan", "pando@test.com");

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.dfiii33.com/youtube",
                    "Coding !!!"
            );

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
