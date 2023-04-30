package com.victorca.StudentManager.utils;

import com.github.javafaker.Faker;
import com.victorca.StudentManager.model.Student;

import java.util.HashMap;
import java.util.UUID;


public class Utils {

    public static String createUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }

    public static HashMap<String, Student> populateStudents(int qty, HashMap<String, Student> students ) {

        Faker faker = new Faker();
        Student newStudent;

        for (int i = 0; i < qty; i++) {
            newStudent = new Student();

            String studentID = Utils.createUUID();
            newStudent.setStudentID(studentID);

            String studentFirstName = faker.name().firstName();
            newStudent.setFirstName(studentFirstName);

            String studentLastName = faker.name().lastName();
            newStudent.setLastName(studentLastName);

            newStudent.setEmail("fake@email.com");

            students.put(studentID, newStudent);

        }
        return  students;
    }
}