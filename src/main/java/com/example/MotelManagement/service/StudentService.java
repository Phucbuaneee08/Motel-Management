package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

}
