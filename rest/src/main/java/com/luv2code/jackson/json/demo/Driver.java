package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();

            Student student1 =
                    mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println(student1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
