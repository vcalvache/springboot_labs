package com.victorca.StudentAdministration.service;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.model.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    public static ArrayList<Student> students = new ArrayList<Student>();

    static{
        Faker faker = new Faker();
        List<String> subjects = new ArrayList<>();
        subjects.add(faker.university().name());
        subjects.add(faker.university().name());

        Student fakeStudent = new Student(faker.idNumber(), faker.name().firstName(), faker.name().lastName(),
                faker.number().numberBetween(18, 100), faker.number().numberBetween(1, 4), subjects);
        students.add(fakeStudent);
    }

    public ArrayList<Student> getAllStudents(){
        return students;
    }

    public void createStudent(Student student){
        students.add(student);
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

    public Student getStudent(IdNumber idNumber){
        int index = getIndex(idNumber);
        if (index != -1){
            students.get(index);
            return students.get(index);
        }

        return  null;
    }

    public void updateStudent(Student updatedStudent){
        int index = getIndex(updatedStudent.getIdNumber());
        if (index != -1){
            students.get(index).setFirstName(updatedStudent.getFirstName());
            students.get(index).setLastName(updatedStudent.getLastName());
            students.get(index).setLastName(updatedStudent.getLastName());
            students.get(index).setLastName(updatedStudent.getLastName());
            students.get(index).setAge(updatedStudent.getAge());
            students.get(index).setCurrentCourse(updatedStudent.getCurrentCourse());
            students.get(index).setSubscribedSubjects(updatedStudent.getSubscribedSubjects());
        }
    }

    public void deleteStudent(Student studentToDelete){
        int index = getIndex(studentToDelete.getIdNumber());

        if (index != -1){
            students.remove(index);
        }
    }
}
