package com.victorca.StudentRegistration.model;

import com.victorca.StudentRegistration.utils.Utils;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private ArrayList<String> subjects;

    public Student(String firstName, String lastName){
        this.studentID = Utils.createUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = new ArrayList<>();
    }
    public Student(String firstName, String lastName, ArrayList<String> subjects){
        this.studentID = Utils.createUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }



}
