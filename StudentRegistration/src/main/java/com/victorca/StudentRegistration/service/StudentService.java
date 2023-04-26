package com.victorca.StudentRegistration.service;

import com.victorca.StudentRegistration.model.Student;
import com.victorca.StudentRegistration.utils.Utils;
import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class StudentService {

    public static HashMap<String, Student> students = new HashMap<String, Student>();

    static{
        populateDB(5);
    }

    public static void createStudent() {
        Student fakeStudent = Utils.createStudent();
        students.put(fakeStudent.getStudentID(), fakeStudent);
    }

    public static void populateDB(int qty){
        for(int i = 0; i < qty; i++){
           createStudent();
        }
    }

    public void saveStudent(Student student){
        if(!students.containsKey(student.getStudentID())){
            students.put(student.getStudentID(), student);
        }
    }

    public static Student getStudent(String studentID){
        if(students.containsKey(studentID)){
            return students.get(studentID);
        }
        return null;
    }

    public static HashMap<String, Student> getAllStudents(){
        return students;
    }

    public static void updateStudent(Student updatedStudent){
        if(students.containsKey(updatedStudent.getStudentID())){
           Student studentFromDB = getStudent(updatedStudent.getStudentID());
           if (!studentFromDB.getFirstName().equals(updatedStudent.getFirstName())){
               studentFromDB.setFirstName(updatedStudent.getFirstName());
           }
           if (!studentFromDB.getLastName().equals(updatedStudent.getLastName())){
               studentFromDB.setLastName(updatedStudent.getLastName());
           }
           if (!studentFromDB.getEmail().equals(updatedStudent.getEmail())){
               studentFromDB.setEmail(updatedStudent.getEmail());
           }
           students.put(studentFromDB.getStudentID(), studentFromDB);

        }
    }

    public static void deleteStudent(Student student){
        if(students.containsKey(student.getStudentID())){
            students.remove(student.getStudentID());
        }
    }

}
