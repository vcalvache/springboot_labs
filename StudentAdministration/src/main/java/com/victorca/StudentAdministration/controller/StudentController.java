package com.victorca.StudentAdministration.controller;

import ch.qos.logback.core.model.Model;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.*;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("")
    public String index(Model containerToView){

        return "index";
    }

/*
    @RequestMapping({"/registerStudent", ""})
    public String createStudent(Model containerToView){
        return "registerstudent";
    }
    @GetMapping("/registerStudent")
    public String createStudent(Model containerToView){
    containerToView.add
        
        return "studentForm";
    }
    */

    

    @RequestMapping({"/getAllStudents", ""})
    public String allStudents(Model containerToView){

        return "getallstudents";
    }


    @RequestMapping("/getStudent")
    public String getStudent(){

        return "getstudent";
    }


    @RequestMapping("/updateStudent")
    public String updateStudents(){

        return "updatestudent";
    }


    @RequestMapping("/deleteStudent")
    public String deleteStudent(){

        return "deletestudent";
    }
}
