package com.victorca.StudentAdministration.repository;

import com.github.javafaker.Faker;
import com.victorca.StudentAdministration.model.Student;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository{
    private List<Student> studentList = new ArrayList<Student>();

    public void createFakeStudent(){
        Faker faker = new Faker();
        List<String> subjects = new ArrayList<>();
        subjects.add(faker.university().name());
        subjects.add(faker.university().name());
        Student fakeStudent = new Student(faker.name().firstName(), faker.name().lastName(),
                faker.number().numberBetween(18, 100), faker.number().numberBetween(1,4), subjects);
        studentList.add(fakeStudent);
    }

    public List<Student> getAllStudents(){
        return studentList;
    }

    public Student getStudent(String firstName, String lastName){
        Student studentFound = new Student();
        for(int i = 0; i< studentList.size(); i++){
            if (studentList.get(i).getFirstName().equals(firstName) &&
            studentList.get(i).getLastName().equals(lastName)){
                studentFound = studentList.get(i);
            }
        }
        return studentFound;
    }
}
