package com.victorca.StudentAdministration.controller;

import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/")
public class StudentController {
    static List<Student> studentsList = new ArrayList<>();



    @RequestMapping("")
    public String index(){
        studentsList.add(ObjectsCreation.createStudent());
        return "welcome";
    }
}
