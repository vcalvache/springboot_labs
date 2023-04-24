package com.victorca.StudentAdministration.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class ObjectsCreation {

    public static Student createStudent(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1, 100);
        String course = faker.university().name();
        IdNumber fakeID = faker.idNumber();

        Student fakeStudent = new Student( fakeID, firstName, lastName, age, course);
        return fakeStudent;
    }

    public static void populateDB(int qty){
        for (int i = 0; i <qty; i++){
            StudentService.students.add(createStudent());
        }

    }
}
