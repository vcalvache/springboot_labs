package com.victorca.StudentManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private String email;
}