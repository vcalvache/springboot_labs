package com.victorca.StudentAdministration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private int currentCourse;
    private List<String> subscribedSubjects;

}
