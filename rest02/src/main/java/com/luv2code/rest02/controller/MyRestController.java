package com.luv2code.rest02.controller;

import com.luv2code.rest02.domain.Student;
import com.luv2code.rest02.rest.StudentErrorResponse;
import com.luv2code.rest02.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        Map<String ,String> map = new HashMap<>();
        map.put("Java", "Good");
        map.put("Python", "Soso");

        Student student = new Student("sunboem","kim",14, map);
        studentList.add(student);

        map = new HashMap<>();
        map.put("Java", "Bad");
        map.put("Python", "Nice");
        student = new Student("jungchi","Jo",14, map);
        studentList.add(student);
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public List<Student> studentList(){
        return studentList;
    }

    @RequestMapping(value = "students/{studentIndex}", method = RequestMethod.GET)
    public Student student(@PathVariable int studentIndex){
        if(studentIndex >= studentList.size() || studentIndex < 0){
            throw new StudentNotFoundException("Student Not Found - " + studentIndex);
        }

        return studentList.get(studentIndex);
    }
}
