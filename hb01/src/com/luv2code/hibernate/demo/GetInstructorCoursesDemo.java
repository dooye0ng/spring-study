package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg2.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Instructor> resultList =
                    session.createQuery("from Instructor i where i.firstName = 'Tom'", Instructor.class).getResultList();

            for(Instructor instructor : resultList){
                System.out.println("== " + instructor.getFirstName() + " " + instructor.getLastName() + " == ");
                for(Course course : instructor.getCourses()){
                    System.out.println(" == " + course.getTitle() + " == ");
                }
            }

            session.getTransaction().commit();
            System.out.println("Done !!!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
