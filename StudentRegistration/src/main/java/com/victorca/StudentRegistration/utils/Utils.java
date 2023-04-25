package com.victorca.StudentRegistration.utils;

import com.github.javafaker.Faker;
import com.victorca.StudentRegistration.model.Student;

import java.util.ArrayList;
import java.util.UUID;

public class Utils {

    public static String createUUID(){
        UUID uuid = UUID.randomUUID();

        return uuid.toString();
    }

    public static Student createStudent(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String subject = faker.university().name();
        ArrayList<String> subjects = new ArrayList<>();
        subjects.add(subject);

        Student fakeStudent = new Student(firstName, lastName, subjects);

        return fakeStudent;
    }


}
