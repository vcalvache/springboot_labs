package com.victorca.StudentAdministration.model;


import com.github.javafaker.IdNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private IdNumber IdNumber;
    private String firstName;
    private String lastName;
    private int age;
    private int currentCourse;
    private List<String> subscribedSubjects;
}


