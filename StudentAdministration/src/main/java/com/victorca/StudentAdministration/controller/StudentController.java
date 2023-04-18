package com.victorca.StudentAdministration.controller;

import org.springframework.ui.Model;
import com.victorca.StudentAdministration.model.Student;
import com.victorca.StudentAdministration.service.StudentService;
import com.victorca.StudentAdministration.utils.ObjectsCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.*;

@Controller
@RequestMapping("")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("")
    public String index(){
        return "index";
    }


    @RequestMapping("/registerStudent")
    public String createStudent(){
        return "registerstudent";
    }

    /*

    @GetMapping(value={"/registerStudent", "/registerStudent/"})
    public String createStudent(Model containerToView){
        containerToView.addAttribute("student", new Student());
        containerToView.addAttribute("operation", "registerStudent");
        return "registerstudent";
    }
    */


    @RequestMapping({"/getAllStudents", ""})
    public String allStudents(Model containerToView){
        containerToView.addAttribute("studentsFromController", studentService.getAllStudents());
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
