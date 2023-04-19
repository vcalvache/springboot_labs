package com.victorca.StudentAdministration.service;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }
    public Student getStudent(IdNumber idNumber){
        Student studentFound = new Student();
        if (studentRepository.getIndex(idNumber) != -1){
            studentFound = studentRepository.getStudent(idNumber);
        }
        return studentFound;
    }

    public void addStudent(Student student){
        if (studentRepository.getIndex(student.getIdNumber()) != -1){
            studentRepository.addStudent(student);
        }
    }
}
