package com.victorca.StudentAdministration.service;

import com.github.javafaker.Faker;
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

}