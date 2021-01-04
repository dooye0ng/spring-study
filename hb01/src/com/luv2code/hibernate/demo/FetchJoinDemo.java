package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {
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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                                        "JOIN FETCH i.courses " +
                                        "WHERE i.ic=:theInstructorId",
                            Instructor.class);

            query.setParameter("theInstructorId", 7);
            Instructor instructor= query.getSingleResult();

            System.out.println("instructor : " + instructor);
            session.getTransaction().commit();
            session.close();

            System.out.println("courses : " + instructor.getCourses());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
