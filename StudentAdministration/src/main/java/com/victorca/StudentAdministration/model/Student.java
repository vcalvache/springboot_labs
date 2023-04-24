package com.victorca.StudentAdministration.model;


import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private IdNumber idNumber;
    private String firstName;
    private String lastName;
    private int age;
    private String course;

    public Student (String firstName, String lastName, int age, String course, List<String> subscribedSubjects){
        Faker faker = new Faker();
        IdNumber fakeID = faker.idNumber();
        this.idNumber = fakeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }
}


