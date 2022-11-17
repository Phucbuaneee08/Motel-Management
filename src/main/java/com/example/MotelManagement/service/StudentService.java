package com.example.MotelManagement.service;

import com.example.MotelManagement.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
}
