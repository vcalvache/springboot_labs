package com.victorca.StudentAdministration.repository;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.model.Student;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<Student>();

    public void createFakeStudent(){
        Faker faker = new Faker();
        List<String> subjects = new ArrayList<>();
        subjects.add(faker.university().name());
        subjects.add(faker.university().name());

        Student fakeStudent = new Student(faker.idNumber(), faker.name().firstName(), faker.name().lastName(),
                faker.number().numberBetween(18, 100), faker.number().numberBetween(1, 4), subjects);
        students.add(fakeStudent);
    }

    public int getIndex(IdNumber idNumber) {
        int index = 0;
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getIdNumber() == idNumber) {
                index = i;
                break;
            } else {
                index = -1;
            }
        }
        return index;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(IdNumber idNumber) {
        int i = getIndex(idNumber);
        Student studentFound = students.get(i);
        return studentFound;
    }

    public void addStudent(Student student){
        int studentIsPresent = getIndex(student.getIdNumber());
        if (studentIsPresent != -1){
            students.add(student);
        }
    }

}

