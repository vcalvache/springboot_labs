package com.victorca.StudentRegistration.model;

import com.victorca.StudentRegistration.utils.Utils;
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

    public Student(String firstName, String lastName, String email){
        this.studentID = Utils.createUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
