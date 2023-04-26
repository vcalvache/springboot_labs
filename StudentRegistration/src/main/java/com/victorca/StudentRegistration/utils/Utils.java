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
        String email = faker.bothify("email@email.com");

        Student fakeStudent = new Student(firstName, lastName, email);

        return fakeStudent;
    }

}
