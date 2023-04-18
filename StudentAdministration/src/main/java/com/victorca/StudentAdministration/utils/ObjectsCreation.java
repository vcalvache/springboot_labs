package com.victorca.StudentAdministration.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ObjectsCreation {

    public static Student createStudent(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(1, 100);
        int currentCourse = faker.number().numberBetween(1, 10);
        String topic = faker.university().name();
        IdNumber fakeID = faker.idNumber();
        List<String> subjects = new ArrayList<>();
        subjects.add(topic);

        Student fakeStudent = new Student( fakeID, firstName, lastName, age, currentCourse, subjects);
        return fakeStudent;
    }

}
