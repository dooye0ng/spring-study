package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pw = "hbstudent";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database : " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pw);

            System.out.println("Connection successful !!");
        } catch (Exception e){
            e.printStackTrace();
        }



    }
}
