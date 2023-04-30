package com.victorca.StudentManager.service;

import com.victorca.StudentManager.model.Student;
import com.victorca.StudentManager.utils.Utils;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class StudentService {
    public static HashMap<String, Student> students = new HashMap<>();

    static {
        Utils.populateStudents(5, students);
    }

    public static void populateDB(int qty) {
        Utils.populateStudents(qty,students);
    }

    public  void createStudent(Student student) {

        String  studentID = Utils.createUUID();
        student.setStudentID(studentID);
        students.put(studentID, student);
    }

    public HashMap<String, Student> getAllStudents (){
        return students;
    }

    public Student createStudent(){
        Student student = new Student();
        student.setEmail("");
        return student;
    }

    public Student findStudentByID(String studentID) {
        return students.getOrDefault(studentID, null);
    }

    public void updateStudentByStudentID(Student studentFound) {
        students.put(studentFound.getStudentID(), studentFound);
    }

    public void deleteStudentByStudentID(String studentID) {
        students.remove(studentID);
    }
}
