package com.victorca.StudentAdministration.controller;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.victorca.StudentAdministration.repository.StudentRepository;
import org.springframework.ui.Model;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.*;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;


    @RequestMapping("")
    public String index(){
        studentRepository.createFakeStudent();
        return "index";
    }
/*
    @RequestMapping("/registerStudent")
    public String createStudent(){
        return "registerstudent";
    }



    @GetMapping(value={"/registerStudent", "/registerStudent/"})
    public String createStudent(Model containerToView){
        containerToView.addAttribute("student", new Student());
        containerToView.addAttribute("operation", "registerStudent");
        return "registerstudent";
    }

*/
    @RequestMapping({"/getAllStudents", ""})
    public String getAllStudents(Model containerToView) {
        // Retrieve all available users
        containerToView.addAttribute("studentsFromController", studentService.getAllStudents());
        return "getallstudents";
    }

    /*
    @RequestMapping(value="/getStudent/{idNUmber}")
    public String getStudent(@PathVariable("idNumber")IdNumber idNumber, Model containerToView){
        Student studentFromDB = studentService.getStudent(idNumber);
        containerToView.addAttribute("student", studentFromDB);
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
     */

}
