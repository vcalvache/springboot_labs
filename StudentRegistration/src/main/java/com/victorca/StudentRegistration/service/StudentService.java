package com.victorca.StudentRegistration.service;

import com.victorca.StudentRegistration.model.Student;
import com.victorca.StudentRegistration.utils.Utils;
import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class StudentService {

    public HashMap<String, Student> students = new HashMap<String, Student>();

    public void createStudent() {
        Student fakeStudent = Utils.createStudent();
        students.put(fakeStudent.getStudentID(), fakeStudent);
    }

    public void populateDB(int qty){
        for(int i = 0; i < qty; i++){
           createStudent();
        }
    }

    public void saveStudent(Student student){
        if(!students.containsKey(student.getStudentID())){
            students.put(student.getStudentID(), student);
        }
    }

    public Student getStudent(String studentID){
        if(students.containsKey(studentID)){
            return students.get(studentID);
        }
    }

}
