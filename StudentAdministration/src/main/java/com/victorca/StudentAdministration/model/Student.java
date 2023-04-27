package com.victorca.StudentAdministration.model;


import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Student {
    private String idNumber;
    private String firstName;
    private String lastName;
    private int age;
    private String course;

    public Student (String firstName, String lastName, int age, String course){
        this.idNumber = ObjectsCreation.createID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.course = course;
    }
}


