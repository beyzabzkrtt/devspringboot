package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents ;
    @PostConstruct
    public void loadData(){

        theStudents=new ArrayList<>();

        Student s1 = new Student("Beyza","Bozkurt");
        Student s2 = new Student("Ozan","Bozkurt");
        Student s3 = new Student("Nazan","Bozkurt");

        theStudents.add(s1);
        theStudents.add(s2);
        theStudents.add(s3);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        if(studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }



}
