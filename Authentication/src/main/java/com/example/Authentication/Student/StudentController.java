package com.example.Authentication.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

    @RestController
    @RequestMapping("api/v1/students")
    public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
      new Student(1, "James"),
            new Student(2, "Jones"),
            new Student(3, "Maria")
            );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){

        return STUDENTS.stream().filter(s -> studentId.equals(s.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist!"));
    }

    }
