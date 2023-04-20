package com.victorca.StudentAdministration.controller;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import org.springframework.ui.Model;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.*;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    StudentService studentService;


    @RequestMapping("")
    public String index(Model model){
        return "index";
    }

    @RequestMapping(value={"/getAllStudents", "/getAllStudents/"})
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "getallstudents";
    }


    /*
    @GetMapping(value= {"/createStudent", "/createStudent/"})
    public String createStudent(Model containerToView){
        //containerToView.addAttribute("student", new Student());
        //containerToView.addAttribute("operation", "createStudent");
        return "registerstudent";
    }

    @PostMapping("/createStudent/{id}")
    public String createStudent(@PathVariable("id") IdNumber idNumber, Optional<Student> student){

        return"redirect:/createStudent";
    }

    @RequestMapping(value={"/getAllStudents", "/getAllStudents/"})
    public String getAllStudents(Model model) {
        // Retrieve all available users
        model.addAttribute("studentsFromController", studentService.getAllStudents());
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
